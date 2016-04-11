package ger.tree;

import java.util.ArrayList;
import java.util.List;

public class GerTree {

	public static void main(String[] args){
		
		List<Object> a = new ArrayList<>();
		List<Object> b = new ArrayList<>();
		List<Object> c = new ArrayList<>();
		List<Object> d = new ArrayList<>();
		List<Object> e = new ArrayList<>();
		List<Object> f = new ArrayList<>();
		
		c.add("<");
		c.add("1");
		c.add("2");
		
		e.add(">");
		e.add("3");
		e.add("4");
		
		f.add("==");
		f.add("4");
		f.add("10");
		
		b.add("?::");
		b.add(c);
		b.add("5");
		b.add("6");
		
		d.add("?::");
		d.add(e);
		d.add("7");
		d.add(f);
		d.add("8");
		d.add("9");
		
		a.add("+");
		a.add(b);
		a.add(d);
	
		
		List<Object> x = new ArrayList<>();
		List<Object> y = new ArrayList<>();
		List<Object> z = new ArrayList<>();
		
		z.add(">");
		z.add("1");
		z.add("2");
		
		//System.out.println(a);
		//System.out.println(func(a));
		//System.out.println(func(z, z));
		//System.out.println(func(a, a));
		System.out.println("RESULTADO="+func1(a, 0));
		
	}
	
	public static Object func(Object o, Object r){
		Object aux = null;
		List l;
		if(o instanceof List){
			//System.out.println("o: "+o);
			//System.out.println("r: "+r);
			switch(((List)o).get(0).toString()){
			case("+"):
				//System.out.println("+");
				//System.out.println(">");
				l = (List)o;
				if(esHoja(l)){ // Es Hoja
					if(!o.equals(r)){
						aux = func(r, r);
					}
					if(l instanceof List){
						if(esMayorQue(l)){
							aux = func(l, true); // Si uso solo un parametro y lo mando por la funcion, cuando llega al switch no entra en ningun caso ya que es solo un boolean
						}else{
							aux = func(l, false);
						}
					}else{
						aux = l;
					}
					//System.out.println("+l "+aux);
						
				}else{
					for(int i = 1; i < ((List)o).size(); i++){
						if(((List) o).get(i) instanceof List){
							aux = func(((List) o).get(i), ((List) o).get(i));
						}else{
							aux = ((List) o).get(i);
							func(aux, aux);
						}
					}
				}
				break;
			
			case("?::"):
				//System.out.println("?::");
				//System.out.println(">");
				l = (List)o;
				if(esHoja(l)){ // Es Hoja
					if(!o.equals(r)){
						aux = func(r, r);
					}
					if(l instanceof List){
						if(esMayorQue(l)){
							aux = func(l, true); // Si uso solo un parametro y lo mando por la funcion, cuando llega al switch no entra en ningun caso ya que es solo un boolean
						}else{
							aux = func(l, false);
						}
					}else{
						aux = l;
					}
					//System.out.println("+l "+aux);
						
				}else{
					for(int i = 1; i < ((List)o).size(); i++){
						if(((List) o).get(i) instanceof List){
							aux = func(((List) o).get(i), ((List) o).get(i));
						}else{
							aux = ((List) o).get(i);
							func(aux, aux);
						}
					}
				}
				break;
			
			case(">"):
				//System.out.println(">");
				l = (List)o;
				if(esHoja(l)){ // Es Hoja
					if(!o.equals(r)){
						aux = func(r, r);
						return r;
					}
					if(l instanceof List){
						if(esMayorQue(l)){
							aux = func(l, true); // Si uso solo un parametro y lo mando por la funcion, cuando llega al switch no entra en ningun caso ya que es solo un boolean
							return true;
						}else{
							aux = func(l, false);
							return false;
						}
					}else{
						aux = l;
					}
					//System.out.println("+l "+aux);
						
				}else{
					for(int i = 1; i < ((List)o).size(); i++){
						if(((List) o).get(i) instanceof List){
							aux = func(((List) o).get(i), ((List) o).get(i));
						}else{
							aux = ((List) o).get(i);
							func(aux, aux);
						}
					}
				}
			
				break;
				
			case("<"):
				//System.out.println("<");
				l = (List)o;
				if(esHoja(l)){ // Es Hoja, penultimo nivel de objeto array sin array anidados
					if(!o.equals(r)){
						aux = func(r, r);
						return r;
					}
					if(l instanceof List){
						if(esMenorQue(l)){
							aux = func(l, true);
							return true;
						}else{
							aux = func(l, false);
							return false;
						}
					}else{
						aux = l;
					}
				
					//System.out.println("+l "+aux);
						
				}else{
					for(int i = 1; i < ((List)o).size(); i++){
						if(((List) o).get(i) instanceof List){
							aux = func(((List) o).get(i), ((List) o).get(i));
						}else{
							aux = ((List) o).get(i);
							func(aux, aux);
						}
					}
				}
				break;
			}
		}else{
			//System.out.println("RR1:"+o); // VALORES LOCALES DE RESPUESTA NO SON CAPTURADOS PORQUE NO ENTRAN EN LOS CASE, YA QUE NO CONTIENEN EL SIMBOLO 
			//ESPECIAL EN LA PRIMERA POSICION
			return o;
		}
		//System.out.println("RR2:"+o);
		return o;
	}
	
	public static Object func1(Object o, Integer oN){
		Object aux = null;
		List l = null;
		if(o instanceof List){
			switch(((List)o).get(0).toString()){
			case("+"):
				oN+=1;
				//System.out.println("+");
				for(int i = 1; i < ((List)o).size(); i++){
					if(((List) o).get(i) instanceof List){
						l = (List)((List) o).get(i);
						aux = func1(l, oN);
						System.out.println("+l "+aux+ " "+oN);
					}else{
						aux = ((List) o).get(i);
						//System.out.println("+o "+aux+" "+lvl);
						func1(aux, oN);
					}
				}
				break;
			
			case("?::"):
				oN+=1;
				//System.out.println("?::");
				for(int i = 1; i < ((List)o).size(); i++){
					if(((List) o).get(i) instanceof ArrayList){
						l = (List)((List) o).get(i);
						aux = func1(l, oN);
						System.out.println("??:l "+aux+" "+oN);
					}else{
						aux = ((List) o).get(i);
						//System.out.println("??:o "+aux+" "+lvl);
						func1(aux, oN);
					}
				}
				break;
			
			case(">"):
				oN+=1;
				//System.out.println(">");
				for(int i = 1; i < ((List)o).size(); i++){
					if(((List) o).get(i) instanceof ArrayList){
						l = (List)((List) o).get(i);
						aux = func1(l, oN);
						System.out.println(">l "+aux+" "+oN);
					}else{
						aux = ((List) o).get(i);
						//System.out.println(">o "+aux+" "+lvl);
						func1(aux, oN);
					}
				}
				break;
				
			case("<"):
				oN+=1;
				//System.out.println("<");
				for(int i = 1; i < ((List)o).size(); i++){
					if(((List) o).get(i) instanceof ArrayList){
						l = (List)((List) o).get(i);
						aux = func1(l, oN);
						System.out.println("<l "+aux+" "+oN);
					}else{
						aux = ((List) o).get(i);
						//System.out.println("<o "+aux+" "+lvl);
						func1(aux, oN);
					}
				}
			break;
			case("=="):
				oN+=1;
				//System.out.println("<");
				for(int i = 1; i < ((List)o).size(); i++){
					if(((List) o).get(i) instanceof ArrayList){
						l = (List)((List) o).get(i);
						aux = func1(l, oN);
						System.out.println("<l "+aux+" "+oN);
					}else{
						aux = ((List) o).get(i);
						//System.out.println("<o "+aux+" "+lvl);
						func1(aux, oN);
					}
				}
				break;
			}
		}else{
			//System.out.println("RR1:"+o); // VALORES LOCALES DE RESPUESTA NO SON CAPTURADOS PORQUE NO ENTRAN EN LOS CASE, YA QUE NO CONTIENEN EL SIMBOLO 
			//ESPECIAL EN LA PRIMERA POSICION
			return o;
		}
		//ORACIONES DE RECORRIDOS
		System.out.println(oN+"====== "+((List)o).get(0).toString());
		List lR = (List)o;
		switch(lR.get(0).toString()){
			case("<"):
				if(Integer.valueOf(lR.get(1).toString())<Integer.valueOf(lR.get(2).toString())){
					return true;
				}
				return false;
			case(">"):
				if(Integer.valueOf(lR.get(1).toString())>Integer.valueOf(lR.get(2).toString())){
					return true;
				}
				return false;
			case("=="):
				if(lR.get(1).equals(lR.get(2))){
					return true;
				}
				return false;	
			default:
				return o;
		}
		
	}
	
	public static Boolean esHoja(List l){
		for(int i = 1; i < l.size(); i++){
			if(l.get(i) instanceof List){
				//System.out.println("-------"+l);
				//System.out.println("-------"+i);
				return false;
			}
		}
		return true;
	}
	
	public static Boolean esMenorQue(List l){
		Integer min = Integer.valueOf(l.get(1).toString());
		for(int i = 2; i < l.size(); i++){
			Integer value = Integer.valueOf(l.get(i).toString());
			if(value > min){
				return false;
			}else{
				min = value;
			}
		}
		return true;
	}
	
	public static Boolean esMayorQue(List l){
		int max = 0;
		for(int i = 1; i < l.size(); i++){
			Integer value = Integer.valueOf(l.get(i).toString());
			if(value < max){
				return false;
			}else{
				max = value;
			}
		}
		return true;
	}
	
}