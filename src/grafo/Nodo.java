package grafo;

public class Nodo {
    // ************************************************************************
    // * /Atributos\
    // ************************************************************************

    private Object valor;
    private int clave;

    // ************************************************************************
    // * /Constructores\
    // ************************************************************************

    // Ambito paquete. Los vertices se construyen únicamente desde el grafo
    Nodo(int clave, Object valor) {
        this.valor = valor;
        this.clave = clave;
    }

    // ************************************************************************
    // * /Métodos internos\
    // ************************************************************************

    // ************************************************************************
    // * /Métodos Públicos\
    // ************************************************************************

    // ************************************************************************
    // * /Setters & Getters\
    // ************************************************************************

    Object getValor() { // Ambito de paquete. Sin acceso externo al metodo
        return valor;
    }

    void setValor(Object valor) { // Ambito de paquete. Sin acceso externo al metodo
        this.valor = valor;
    }

    int getClave() { // Ambito de paquete. Sin acceso externo al metodo
        return clave;
    }

    void setClave(int clave) { // Ambito de paquete. Sin acceso externo al metodo
        this.clave = clave;
    }

    // ************************************************************************
    // * /Métodos override\
    // ************************************************************************

    @Override
    public String toString() {
        return "[valor=" + valor + ", clave=" + clave + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nodo other = (Nodo) obj;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

}
