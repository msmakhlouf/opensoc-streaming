package com.opensoc.parsing.parsers;

import java.net.URL;

import oi.thekraken.grok.api.Grok;
import oi.thekraken.grok.api.Match;
import oi.thekraken.grok.api.exception.GrokException;

import org.json.simple.JSONObject;

public class GrokParser extends AbstractParser {

	private static final long serialVersionUID = 2145177989368018920L;
	private static final String PATTERN_URL = "bolt.parser.grok.file.path";
	private static final String PATTERN = "bolt.parser.grok.pattern";
	
	Grok grok;
	
	public GrokParser(String filepath, String pattern) throws GrokException
	{

		grok = Grok.create(filepath);
		grok.compile("%{"+pattern+"}");
	}
	
	@Override
	public JSONObject parse(byte[] raw_message) {
		String toParse = "";
		JSONObject toReturn;
		

		try {

			toParse = new String(raw_message, "UTF-8");
			Match gm = grok.match(toParse);
			gm.captures();
			toReturn = new JSONObject();
			toReturn.putAll(gm.toMap());
			return toReturn;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
