package com.trocajogo.model;

public enum StatusTroca {

    TROCA_REJEITADA {
        @Override
        public String toString(){
            return "R";
        }
    },

    TROCA_ANDAMENTO{
    	@Override
    	public String toString() {
    		return "N";
    	}
    },
    TROCA_CANCELADA {
        @Override
        public String toString(){
            return "D";
        }
    },
    TROCA_CONCLUIDA {
        @Override
        public String toString(){
            return "C";
        }
    },

    TROCA_ANALISE {
        @Override
        public String toString() {
            return "A";
        }
    }

}
