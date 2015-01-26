package com.opensoc.parsing;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;

import com.opensoc.helpers.topology.ErrorGenerator;

import oi.thekraken.grok.api.Grok;
import oi.thekraken.grok.api.Match;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class GrokParserBolt extends AbstractParserBolt {

	private static final long serialVersionUID = -7264228743867634627L;
	Grok grok;

	@SuppressWarnings("unchecked")
	public void execute(Tuple input) {
		String toParse = "";
		JSONObject message;
		

		try {
			byte[] raw_message = input.getBinary(0);

			toParse = new String(raw_message, "UTF-8");
			Match gm = grok.match(toParse);
			gm.captures();
			
			message = new JSONObject();
			
			message.putAll(gm.toMap());
			_collector.emit("message", new Values(message));
			
		}
		catch(Exception e)
		{
			_collector.fail(input);
		      LOG.error("Exception while processing tuple", e);
		      
		      String error_as_string = org.apache.commons.lang.exception.ExceptionUtils
						.getStackTrace(e);

				JSONObject error = ErrorGenerator.generateErrorMessage(
						"Alerts problem: " + input.getBinary(0), error_as_string);
				_collector.emit("error", new Values(error));
				
		}
		
		_collector.ack(input);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		  declarer.declareStream("message", new Fields("key", "message")); 
		  declarer.declareStream("error", new Fields("error"));
		
	}

	@Override
	void doPrepare(Map conf, TopologyContext topologyContext,
			OutputCollector collector) throws IOException {
		
		try {
		
		String filepath = conf.get("bolt.parser.grok.file.path").toString();
		String pattern = conf.get("bolt.parser.grok.pattern").toString();
		
		grok = Grok.create(filepath);
		grok.compile("%{"+pattern+"}");
		
		this.registerCounters();		
	} catch (Exception e) {
		
		e.printStackTrace();
		
		String error_as_string = org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e);
		
		JSONObject error = ErrorGenerator.generateErrorMessage(new String("Error initializing Grok Parser"), error_as_string);
		_collector.emit("error", new Values(error));
	}
	}

}
