package compilador;

public class Declaracion {
    private String nombreVariable;
    private String tipoVariable;
    private String valorVariable;

    /**
     * @return the nombreVariable
     */
    public String getNombreVariable() {
        return nombreVariable;
    }

    /**
     * @param nombreVariable the nombreVariable to set
     */
    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    /**
     * @return the tipoVariable
     */
    public String getTipoVariable() {
        return tipoVariable;
    }

    /**
     * @param tipoVariable the tipoVariable to set
     */
    public void setTipoVariable(String tipoVariable) {
        this.tipoVariable = tipoVariable;
    }

    /**
     * @return the valorVariable
     */
    public String getValorVariable() {
        return valorVariable;
    }

    /**
     * @param valorVariable the valorVariable to set
     */
    public void setValorVariable(String valorVariable) {
        this.valorVariable = valorVariable;
    }
    
}
