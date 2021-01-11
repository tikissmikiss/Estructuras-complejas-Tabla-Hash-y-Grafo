package hash;

class ClaveValor {
    // Ámbito de paquete. Sin setters y getters
    String clave;
    Object valor;

    public ClaveValor(String clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[clave=" + clave + ", valor=" + valor + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
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
        ClaveValor other = (ClaveValor) obj;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        return true;
    }

}
