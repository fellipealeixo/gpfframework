/* The following code was generated by JFlex 1.4.1 on 18/12/07 10:16 */

package br.pucrio.inf.les.genarch.core.logic.model.expressions.parse;

import java_cup.runtime.Symbol;

/**
 * This class is a simple example lexer.
 */

public class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\3\1\0\1\0\3\0\16\3\4\0\1\1\3\0\1\2\3\0"+
    "\1\12\1\13\6\0\12\3\7\0\32\2\4\0\1\2\1\0\1\6"+
    "\2\2\1\10\11\2\1\7\1\4\2\2\1\5\1\2\1\11\6\2"+
    "\4\0\41\3\2\0\4\2\4\0\1\2\2\0\1\3\7\0\1\2"+
    "\4\0\1\2\5\0\27\2\1\0\37\2\1\0\u013f\2\31\0\162\2"+
    "\4\0\14\2\16\0\5\2\11\0\1\2\21\0\130\3\5\0\23\3"+
    "\12\0\1\2\13\0\1\2\1\0\3\2\1\0\1\2\1\0\24\2"+
    "\1\0\54\2\1\0\46\2\1\0\5\2\4\0\202\2\1\0\4\3"+
    "\3\0\105\2\1\0\46\2\2\0\2\2\6\0\20\2\41\0\46\2"+
    "\2\0\1\2\7\0\47\2\11\0\21\3\1\0\27\3\1\0\3\3"+
    "\1\0\1\3\1\0\2\3\1\0\1\3\13\0\33\2\5\0\3\2"+
    "\15\0\4\3\14\0\6\3\13\0\32\2\5\0\13\2\16\3\7\0"+
    "\12\3\4\0\2\2\1\3\143\2\1\0\1\2\10\3\1\0\6\3"+
    "\2\2\2\3\1\0\4\3\2\2\12\3\3\2\2\0\1\2\17\0"+
    "\1\3\1\2\1\3\36\2\33\3\2\0\3\2\60\0\46\2\13\3"+
    "\1\2\u014f\0\3\3\66\2\2\0\1\3\1\2\20\3\2\0\1\2"+
    "\4\3\3\0\12\2\2\3\2\0\12\3\21\0\3\3\1\0\10\2"+
    "\2\0\2\2\2\0\26\2\1\0\7\2\1\0\1\2\3\0\4\2"+
    "\2\0\1\3\1\2\7\3\2\0\2\3\2\0\3\3\11\0\1\3"+
    "\4\0\2\2\1\0\3\2\2\3\2\0\12\3\4\2\15\0\3\3"+
    "\1\0\6\2\4\0\2\2\2\0\26\2\1\0\7\2\1\0\2\2"+
    "\1\0\2\2\1\0\2\2\2\0\1\3\1\0\5\3\4\0\2\3"+
    "\2\0\3\3\13\0\4\2\1\0\1\2\7\0\14\3\3\2\14\0"+
    "\3\3\1\0\11\2\1\0\3\2\1\0\26\2\1\0\7\2\1\0"+
    "\2\2\1\0\5\2\2\0\1\3\1\2\10\3\1\0\3\3\1\0"+
    "\3\3\2\0\1\2\17\0\2\2\2\3\2\0\12\3\1\0\1\2"+
    "\17\0\3\3\1\0\10\2\2\0\2\2\2\0\26\2\1\0\7\2"+
    "\1\0\2\2\1\0\5\2\2\0\1\3\1\2\6\3\3\0\2\3"+
    "\2\0\3\3\10\0\2\3\4\0\2\2\1\0\3\2\4\0\12\3"+
    "\1\0\1\2\20\0\1\3\1\2\1\0\6\2\3\0\3\2\1\0"+
    "\4\2\3\0\2\2\1\0\1\2\1\0\2\2\3\0\2\2\3\0"+
    "\3\2\3\0\10\2\1\0\3\2\4\0\5\3\3\0\3\3\1\0"+
    "\4\3\11\0\1\3\17\0\11\3\11\0\1\2\7\0\3\3\1\0"+
    "\10\2\1\0\3\2\1\0\27\2\1\0\12\2\1\0\5\2\4\0"+
    "\7\3\1\0\3\3\1\0\4\3\7\0\2\3\11\0\2\2\4\0"+
    "\12\3\22\0\2\3\1\0\10\2\1\0\3\2\1\0\27\2\1\0"+
    "\12\2\1\0\5\2\2\0\1\3\1\2\7\3\1\0\3\3\1\0"+
    "\4\3\7\0\2\3\7\0\1\2\1\0\2\2\4\0\12\3\22\0"+
    "\2\3\1\0\10\2\1\0\3\2\1\0\27\2\1\0\20\2\4\0"+
    "\6\3\2\0\3\3\1\0\4\3\11\0\1\3\10\0\2\2\4\0"+
    "\12\3\22\0\2\3\1\0\22\2\3\0\30\2\1\0\11\2\1\0"+
    "\1\2\2\0\7\2\3\0\1\3\4\0\6\3\1\0\1\3\1\0"+
    "\10\3\22\0\2\3\15\0\60\2\1\3\2\2\7\3\4\0\10\2"+
    "\10\3\1\0\12\3\47\0\2\2\1\0\1\2\2\0\2\2\1\0"+
    "\1\2\2\0\1\2\6\0\4\2\1\0\7\2\1\0\3\2\1\0"+
    "\1\2\1\0\1\2\2\0\2\2\1\0\4\2\1\3\2\2\6\3"+
    "\1\0\2\3\1\2\2\0\5\2\1\0\1\2\1\0\6\3\2\0"+
    "\12\3\2\0\2\2\42\0\1\2\27\0\2\3\6\0\12\3\13\0"+
    "\1\3\1\0\1\3\1\0\1\3\4\0\2\3\10\2\1\0\42\2"+
    "\6\0\24\3\1\0\2\3\4\2\4\0\10\3\1\0\44\3\11\0"+
    "\1\3\71\0\42\2\1\0\5\2\1\0\2\2\1\0\7\3\3\0"+
    "\4\3\6\0\12\3\6\0\6\2\4\3\106\0\46\2\12\0\51\2"+
    "\7\0\132\2\5\0\104\2\5\0\122\2\6\0\7\2\1\0\77\2"+
    "\1\0\1\2\1\0\4\2\2\0\7\2\1\0\1\2\1\0\4\2"+
    "\2\0\47\2\1\0\1\2\1\0\4\2\2\0\37\2\1\0\1\2"+
    "\1\0\4\2\2\0\7\2\1\0\1\2\1\0\4\2\2\0\7\2"+
    "\1\0\7\2\1\0\27\2\1\0\37\2\1\0\1\2\1\0\4\2"+
    "\2\0\7\2\1\0\47\2\1\0\23\2\16\0\11\3\56\0\125\2"+
    "\14\0\u026c\2\2\0\10\2\12\0\32\2\5\0\113\2\3\0\3\2"+
    "\17\0\15\2\1\0\4\2\3\3\13\0\22\2\3\3\13\0\22\2"+
    "\2\3\14\0\15\2\1\0\3\2\1\0\2\3\14\0\64\2\40\3"+
    "\3\0\1\2\3\0\2\2\1\3\2\0\12\3\41\0\3\3\2\0"+
    "\12\3\6\0\130\2\10\0\51\2\1\3\126\0\35\2\3\0\14\3"+
    "\4\0\14\3\12\0\12\3\36\2\2\0\5\2\u038b\0\154\2\224\0"+
    "\234\2\4\0\132\2\6\0\26\2\2\0\6\2\2\0\46\2\2\0"+
    "\6\2\2\0\10\2\1\0\1\2\1\0\1\2\1\0\1\2\1\0"+
    "\37\2\2\0\65\2\1\0\7\2\1\0\1\2\3\0\3\2\1\0"+
    "\7\2\3\0\4\2\2\0\6\2\4\0\15\2\5\0\3\2\1\0"+
    "\7\2\17\0\4\3\32\0\5\3\20\0\2\2\23\0\1\2\13\0"+
    "\4\3\6\0\6\3\1\0\1\2\15\0\1\2\40\0\22\2\36\0"+
    "\15\3\4\0\1\3\3\0\6\3\27\0\1\2\4\0\1\2\2\0"+
    "\12\2\1\0\1\2\3\0\5\2\6\0\1\2\1\0\1\2\1\0"+
    "\1\2\1\0\4\2\1\0\3\2\1\0\7\2\3\0\3\2\5\0"+
    "\5\2\26\0\44\2\u0e81\0\3\2\31\0\11\2\6\3\1\0\5\2"+
    "\2\0\5\2\4\0\126\2\2\0\2\3\2\0\3\2\1\0\137\2"+
    "\5\0\50\2\4\0\136\2\21\0\30\2\70\0\20\2\u0200\0\u19b6\2"+
    "\112\0\u51a6\2\132\0\u048d\2\u0773\0\u2ba4\2\u215c\0\u012e\2\2\0\73\2"+
    "\225\0\7\2\14\0\5\2\5\0\1\2\1\3\12\2\1\0\15\2"+
    "\1\0\5\2\1\0\1\2\1\0\2\2\1\0\2\2\1\0\154\2"+
    "\41\0\u016b\2\22\0\100\2\2\0\66\2\50\0\15\2\3\0\20\3"+
    "\20\0\4\3\17\0\2\2\30\0\3\2\31\0\1\2\6\0\5\2"+
    "\1\0\207\2\2\0\1\3\4\0\1\2\13\0\12\3\7\0\32\2"+
    "\4\0\1\2\1\0\32\2\12\0\132\2\3\0\6\2\2\0\6\2"+
    "\2\0\6\2\2\0\3\2\3\0\2\2\3\0\2\2\22\0\3\3"+
    "\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\4\3\1\4\1\5\1\6\2\3"+
    "\1\7\1\10";

  private static int [] zzUnpackAction() {
    int [] result = new int[14];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\14\0\14\0\30\0\44\0\60\0\74\0\14"+
    "\0\14\0\30\0\110\0\124\0\30\0\30";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[14];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\4\1\6\1\7"+
    "\2\4\1\10\1\11\16\0\10\4\4\0\3\4\1\12"+
    "\4\4\4\0\5\4\1\13\2\4\4\0\2\4\1\14"+
    "\5\4\4\0\6\4\1\15\1\4\4\0\7\4\1\16"+
    "\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\4\1\2\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[14];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  StringBuilder string = new StringBuilder();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
  
  public int yycolumn() {
  	return this.yycolumn;
  }
  


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1682) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { return symbol(sym.LPAREN);
          }
        case 9: break;
        case 3: 
          { return symbol(sym.FEATURE, yytext());
          }
        case 10: break;
        case 2: 
          { /* ignore */
          }
        case 11: break;
        case 8: 
          { return symbol(sym.NOT);
          }
        case 12: break;
        case 7: 
          { return symbol(sym.AND);
          }
        case 13: break;
        case 6: 
          { return symbol(sym.OR);
          }
        case 14: break;
        case 1: 
          { throw new Error("Illegal character <"+
                                                    yytext()+">");
          }
        case 15: break;
        case 5: 
          { return symbol(sym.RPAREN);
          }
        case 16: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
