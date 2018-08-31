package ru.csc.java.networking.serialization;

import java.io.*;

public class ExternalizableAnimal implements Externalizable {

    private static final long serialVersionUID = 44444444;

    private String name;

    public ExternalizableAnimal() {
    }

    public ExternalizableAnimal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        if (name == null) {
            out.writeBoolean(false);
        } else {
            out.writeBoolean(true);
            out.writeUTF(name);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        if (in.readBoolean()) {
            name = in.readUTF();
        } else {
            name = null;
        }
    }
}
