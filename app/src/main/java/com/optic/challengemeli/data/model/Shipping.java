package com.optic.challengemeli.data.model;

import java.util.ArrayList;

/*
 * CONTIENE LA INFORMACION DEL ENVIO DEL PRODUCTO
 */
public class Shipping{
    public String mode;
    public ArrayList<Object> methods;
    public ArrayList<String> tags;
    public Object dimensions;
    public boolean local_pick_up;
    public boolean free_shipping;
    public String logistic_type;
    public boolean store_pick_up;

    public Shipping() {
    }

    public Shipping(String mode, ArrayList<Object> methods, ArrayList<String> tags, Object dimensions, boolean local_pick_up, boolean free_shipping, String logistic_type, boolean store_pick_up) {
        this.mode = mode;
        this.methods = methods;
        this.tags = tags;
        this.dimensions = dimensions;
        this.local_pick_up = local_pick_up;
        this.free_shipping = free_shipping;
        this.logistic_type = logistic_type;
        this.store_pick_up = store_pick_up;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public ArrayList<Object> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<Object> methods) {
        this.methods = methods;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Object getDimensions() {
        return dimensions;
    }

    public void setDimensions(Object dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isLocal_pick_up() {
        return local_pick_up;
    }

    public void setLocal_pick_up(boolean local_pick_up) {
        this.local_pick_up = local_pick_up;
    }

    public boolean isFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(boolean free_shipping) {
        this.free_shipping = free_shipping;
    }

    public String getLogistic_type() {
        return logistic_type;
    }

    public void setLogistic_type(String logistic_type) {
        this.logistic_type = logistic_type;
    }

    public boolean isStore_pick_up() {
        return store_pick_up;
    }

    public void setStore_pick_up(boolean store_pick_up) {
        this.store_pick_up = store_pick_up;
    }
}