/*
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
 */
package herenciasextrasej1.Barco;

public class Barco {
    
    private int matricula;
    private int esloraEnMetros;
    private int anioDeFabricacion;
    private int potenciaCVBarcoAMotor;
    private int potenciaCVNumeroDeCamarotes;

    public Barco() {
    }

    public Barco(int matricula, int esloraEnMetros, int anioDeFabricacion, int potenciaCVBarcoAMotor, int potenciaCVNumeroDeCamarotes) {
        this.matricula = matricula;
        this.esloraEnMetros = esloraEnMetros;
        this.anioDeFabricacion = anioDeFabricacion;
        this.potenciaCVBarcoAMotor = potenciaCVBarcoAMotor;
        this.potenciaCVNumeroDeCamarotes = potenciaCVNumeroDeCamarotes;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getEsloraEnMetros() {
        return esloraEnMetros;
    }

    public void setEsloraEnMetros(int esloraEnMetros) {
        this.esloraEnMetros = esloraEnMetros;
    }

    public int getAnioDeFabricacion() {
        return anioDeFabricacion;
    }

    public void setAnioDeFabricacion(int anioDeFabricacion) {
        this.anioDeFabricacion = anioDeFabricacion;
    }

    public int getPotenciaCVBarcoAMotor() {
        return potenciaCVBarcoAMotor;
    }

    public void setPotenciaCVBarcoAMotor(int potenciaCVBarcoAMotor) {
        this.potenciaCVBarcoAMotor = potenciaCVBarcoAMotor;
    }

    public int getPotenciaCVNumeroDeCamarotes() {
        return potenciaCVNumeroDeCamarotes;
    }

    public void setPotenciaCVNumeroDeCamarotes(int potenciaCVNumeroDeCamarotes) {
        this.potenciaCVNumeroDeCamarotes = potenciaCVNumeroDeCamarotes;
    }
    
    
}
