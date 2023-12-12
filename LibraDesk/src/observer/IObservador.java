package observer;

import model.EmprestimoModel;

public interface IObservador {
    public void atualizarStatus(EmprestimoModel emprestimo);
}
