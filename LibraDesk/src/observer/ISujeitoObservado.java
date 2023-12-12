
package observer;

public interface ISujeitoObservado {
    void adicionarObservador(IObservador observador);
    void removerObservador(IObservador observador);
    void notificarObservadores();
}
