package test.java;

import java.io.Serializable;

public class SingleTone implements Serializable, Cloneable {
    private static final long serialVersionUID = -7921604620670225986L;

    private static SingleTone _instance=null;

    private SingleTone() {
        if(_instance!=null){
            throw new InstantiationError("Already Object Created");
        }
    }

    protected Object readResovle(){
        return _instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public SingleTone getInstance(){
        if (_instance==null){
            synchronized (SingleTone.class){
                if (_instance==null){
                    _instance = new SingleTone();
                }
            }
        }
        return _instance;
    }
}
