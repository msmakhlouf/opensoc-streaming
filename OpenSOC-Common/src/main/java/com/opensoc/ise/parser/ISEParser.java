/* Generated By:JavaCC: Do not edit this line. ISEParser.java */
package com.opensoc.ise.parser;
import java.io.*;
import java.util.*;

import org.json.simple.*;

/**
* Basic ISE data parser generated by JavaCC. 
*/
public class ISEParser implements Serializable, ISEParserConstants {
 // private boolean nativeNumbers = false;

	private static final long serialVersionUID = -2531656825360044979L;

	public ISEParser()
	  { //do nothing
	  }

  public ISEParser(String input)
  {
    this (new StringReader(input));
  }

  /**
	* Parses a ISE String into a JSON object {@code Map}.
	*/
  public JSONObject parseObject() throws ParseException
  {
    JSONObject toReturn = object();
    if (!ensureEOF()) throw new IllegalStateException("Expected EOF, but still had content to parse");
    return toReturn;
  }

  @SuppressWarnings("unused")
final public boolean ensureEOF() throws ParseException {
    switch (jj_nt.kind) {
    case COMMA:
      jj_consume_token(COMMA);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(0);
    {if (true) return true;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings({ "unchecked", "unused" })
final public JSONObject innerMap() throws ParseException {
  final JSONObject json = new JSONObject();
  String key;
  Object value;
    key = objectKey();
    jj_consume_token(EQUALS);
    value = value();
    json.put(key, value);
    key = null;
    value = null;
    label_1:
    while (true) {
      switch (jj_nt.kind) {
      case SLASH:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(SLASH);
      jj_consume_token(COMMA);
      key = objectKey();
      jj_consume_token(EQUALS);
      value = value();
      json.put(key, value);
      key = null;
      value = null;
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings({ "unused", "unchecked" })
final public JSONObject object() throws ParseException {
  final JSONObject json = new JSONObject();
  String key;
  Object value;
    key = objectKey();
    jj_consume_token(EQUALS);
    value = value();
    json.put(key, value);
    key = null;
    value = null;
    label_2:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_2;
      }
      jj_consume_token(COMMA);
      key = objectKey();
      jj_consume_token(EQUALS);
      value = value();
        json.put(key, value);
        key = null;
        value = null;
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String objectKey() throws ParseException {
  String k;
    k = string();
    //  System.out.println("key == " + k);
    {if (true) return k.trim();}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings({ "unused", "rawtypes" })
final public Object value() throws ParseException {
  Object x;
  String eof = "EOF";
  Map m = null;
    if (jj_2_2(2147483647)) {
      x = nullValue();
    } else if (jj_2_3(2147483647)) {
      x = innerMap();
    } else {
      switch (jj_nt.kind) {
      case TAG:
        x = tagString();
        break;
      default:
        jj_la1[2] = jj_gen;
        if (jj_2_4(2147483647)) {
          x = blankValue();
        } else if (jj_2_5(2147483647)) {
          x = braced_string();
        } else if (jj_2_6(2)) {
          x = string();
        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    //  System.out.println("val == " + x);
    //if (x instanceof Map) return "Map";
    //return (String) x;
    {if (true) return x;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String nullValue() throws ParseException {
    {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String tagString() throws ParseException {
  String output = "(tag=0)";
    jj_consume_token(TAG);
    jj_consume_token(STRING_BODY);
    {if (true) return output + token.image;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String blankValue() throws ParseException {
    {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String string() throws ParseException {
  String s;
    jj_consume_token(STRING_BODY);
    {if (true) return token.image.trim();}
    throw new Error("Missing return statement in function");
  }

  @SuppressWarnings("unused")
final public String braced_string() throws ParseException {
  String s;
    jj_consume_token(BRACED_STRING);
    //  System.out.println("braced == " + token.image);
    s = token.image;
    jj_consume_token(COMMA);
    {if (true) return s.trim();}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_3_5() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(0)) return true;
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(BRACED_STRING)) return true;
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_3R_3()) return true;
    if (jj_scan_token(EQUALS)) return true;
    if (jj_3R_7()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_8()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_3()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_scan_token(STRING_BODY)) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) {
    jj_scanpos = xsp;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3_6()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_16() {
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(TAG)) return true;
    if (jj_scan_token(STRING_BODY)) return true;
    return false;
  }

  private boolean jj_3R_3() {
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_scan_token(SLASH)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_3()) return true;
    if (jj_scan_token(EQUALS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_14() {
    return false;
  }

  /** Generated Token Manager. */
  public ISEParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0x80,0x100,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[6];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public ISEParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ISEParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ISEParserTokenManager(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public ISEParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new ISEParserTokenManager(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public ISEParser(ISEParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ISEParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken = token;
    if ((token = jj_nt).next != null) jj_nt = jj_nt.next;
    else jj_nt = jj_nt.next = token_source.getNextToken();
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    jj_nt = token;
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error {

	private static final long serialVersionUID = -5724812746511794505L; }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if ((token = jj_nt).next != null) jj_nt = jj_nt.next;
    else jj_nt = jj_nt.next = token_source.getNextToken();
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[11];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 11; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 6; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
