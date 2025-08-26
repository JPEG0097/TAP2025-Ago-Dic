package moneda;
public class Cajero {
    private double cantidad;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public double Cambio(){
        double cantidadR=cantidad;
        double mon1,mon2,mon5,mon10;
        double b20,b50,b100,b200,b500,b1000;
        if(cantidad==0){
            System.out.println("Termino el programa");
            return 0;
        }
        if(cantidadR>=1000){
            b1000=cantidadR/1000;
            cantidadR%=1000;
        }
        if(cantidadR>=500){
            b500=cantidadR/500;
            cantidadR%=500;
        }
        if(cantidadR>=200){
            b200=cantidadR/200;
            cantidadR%=200;
        }
        if(cantidadR>=100){
            b100=cantidadR/100;
            cantidadR%=100;
        }
        if(cantidad>=50){
            b50=cantidadR/50;
            cantidadR%=50;
        }
        if(cantidad>=20){
            b20=cantidadR/20;
            cantidadR%=20;
        }
        if(cantidad>=10){
            mon10=cantidadR/10;
            cantidadR%=10;
        }
        if(cantidad>=5){
            mon5=cantidadR/5;
            cantidadR%=5;
        }
        if(cantidad>=2){
            mon2=cantidadR/2;
            cantidadR%=2;
        }
        if(cantidad>=1){
            mon1=cantidadR/1;
            cantidadR%=1;
        }
        return cantidadR;
    }
}
