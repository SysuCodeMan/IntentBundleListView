package com.example.chen.experiment3;

import java.io.Serializable;

/**
 * Created by Chen on 2016/10/16.
 */

public class Contract implements Serializable{
        private String Name;
        private String Phone;
        private String Type;
        private String Belonging;
        private String Background;

        public Contract(String _Name, String _Phone, String _Type, String _Belonging, String _Background) {
            Name = _Name;
            Phone = _Phone;
            Type = _Type;
            Belonging = _Belonging;
            Background = _Background;
        }

        public String getName() {
            return  Name;
        }

        public String getPhone() {
            return Phone;
        }

        public String getType() {
            return  Type;
        }

        public String getBelonging() {
            return  Belonging;
        }

        public String getBackground() {
            return Background;
        }
    }

