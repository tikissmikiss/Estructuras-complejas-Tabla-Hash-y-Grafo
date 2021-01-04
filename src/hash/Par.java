package hash;

class Par {
    // Ambito de paquete. Sin setters y getters
    String clave;
    Object valor;

    public Par(String clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[clave=" + clave + ", valor=" + valor + "]";
    }

}
