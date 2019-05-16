package br.ufc.mobile.vendasfacil.ui;

public class View {

    public interface ViewDetails<T>{
        T getData();
        void finishActivity();
        void showText(String s);
    }

}
