package entities;

public class Agente extends Entidad {
    private String habilidadEspecial;
    private String misionAsignada;
    private String equipoActual;  // Atributo para almacenar el equipo actual del agente
    
    public Agente(int id, String nombre, String habilidadEspecial) {
        super(id, nombre);
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void asignarMision(String mision) {
        this.misionAsignada = mision;
    }

    // Método para asignar un equipo al agente
    public void asignarEquipo(String equipo) {
        this.equipoActual = equipo;
    }
    public boolean PerteneceEquipo(){
        return equipoActual != null && !equipoActual.isEmpty();
    }

    // Método toString actualizado para incluir el equipo asignado
    @Override
    public String toString() {
        return super.toString() + ", Habilidad Especial: " + habilidadEspecial +
                (misionAsignada != null ? ", Misión: " + misionAsignada : "") +
                (equipoActual != null ? ", Equipo: " + equipoActual : "");
    }
}
