public enum Color {

    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    PURPLE("Purple"),
    CYAN("Cyan"),
    WHITE("White");
	
	private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}