package ar.edu.utn.frba.dds.model.prenda;

public class Clima {
    public String   sys;
    public int      id;
    public String   appid;
    public String   units;
    public String   main;

    public String allData(){
        return
                "first name: "          +this.id+ "\n"
                        +"last name. "  +this.sys + "\n"
                        +"last name. "  +this.appid + "\n"
                        +"avatar: "     + this.main;
    }

}
