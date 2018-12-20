package albert.macaraeg.com.macaraegalbertlab8;

public class Details {

    private int _id;
    private String _textfullname;
    private String _textage;
    private String _textgender;

    public Details(String s){

    }

    public Details(String textfullname, String textage, String textgender) {
        this._textfullname = textfullname;
        this._textage = textage;
        this._textgender = textgender;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_textfullname(String _textfullname) {
        this._textfullname = _textfullname;
    }

    public void set_textage(String _textage) {
        this._textage = _textage;
    }

    public void set_textgender(String _textgender) {
        this._textgender = _textgender;
    }


    public int get_id() {
        return _id;
    }

    public String get_textfullname() {
        return _textfullname;
    }

    public String get_textage() {
        return _textage;
    }

    public String get_textgender() {
        return _textgender;
    }
}
