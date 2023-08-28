package cucumber.utils;

public class DecorateFormat {
	public final String PATTERN_JIRA = "and 'create Jira Issue = true'";
	public final String COLOR_MESSAGE = "<b><i style='color: #FF0000'>" + "<span style='color: #FF0000;font-size:24px'>Oops...</span>";
	public final String SUB_COLOR_MESAGE = "</u></i></b>";
	public final String THROW_MESSAGE = "The result is not matched";
	public final String COLOR_ACTUAL = "Actual	 : ";
	public final String COLOR_EXPECTED = "Expected : ";
	public final String WHITE_SPACE = " ";
	public final String EMPTY = "";
	public final String BRACKETS_OPEN = "[";
	public final String BRACKETS_CLOSE = "]";
	public final String PARENTHESE_OPEN = "(";
	public final String PARENTHESE_CLOSE = ")";
	public final String COMMA = ",";
	public final String SPACE = "\\s+";
	public final String UNDER_CORE = "_";
	public final String IMAGES_TYPE = "image/png";
	public final String LINE_SEPARATOR = System.lineSeparator();
	public final String LINES = LINE_SEPARATOR + "------------------------------------------------------------------------------------------------" + LINE_SEPARATOR;
	public final String LINES_STAR = LINE_SEPARATOR + "********************************************" + LINE_SEPARATOR;
	public final String PROJECT = "project=";
	public final String AND =" AND ";
	public final String SLASH = "\""; // format search summary "Text"
	public final String TODO = "To Do";
	public final String INPROGRESS = "In Progress";
	public final String STATUS = "status in " + PARENTHESE_OPEN + SLASH + TODO + SLASH + COMMA + SLASH + INPROGRESS + SLASH + PARENTHESE_CLOSE;
	public final String SUMMARY = "summary~";
	public final String STYLE  = "style";
	public final String COLOR_PROPERTIES = "border-style: solid; border-width:1px; border-color: #FF3300;";
	public final String JS_ARGUMENT = "arguments[0].setAttribute(arguments[1], arguments[2]);";
}
