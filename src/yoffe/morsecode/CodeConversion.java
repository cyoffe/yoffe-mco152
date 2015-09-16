package yoffe.morsecode;

public enum CodeConversion {
	A('a', ".-"), B('b', "-..."), C('c', "-.-."), D('d', "-.."), E('e', "."), 
	F('f', "..-."), G('g', "--."), H('h', "...."), I('i', ".."), J('j', ".---"), 
	K('k', "-.-"), L('l', ".-.."), M('m', "--"), N('n', "-."), O('o', "---"), P('p', ".--."), 
	Q('q', "--.-"), R('r', ".-."), S('s', "..."), T('t', "-"), U('u', "..-"), V('v', "...-"), 
	W('w', ".--"), X('x', "-..-"), Y('y', "-.--"), Z('z', "--.."), 
	ONE('1',".----"), TWO('2',"..---"), THREE('3',"...--"), FOUR('4',"....-"), 
	FIVE('5', "....."), SIX('6', "-...."), SEVEN('7', "--..."), EIGHT('8', "---.."), 
	NINE('9', "----."), ZERO('0', "-----");
	
	private String code;
	private char character;
		
	private CodeConversion(char character, String code){
		this.character = character;
		this.code = code;
	}
	
	public String getCodeConversion(){
		return code;
	}
	
	public char getCharacterConversion(){
		return character;
	}
}
