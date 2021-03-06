package ger.tree;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class GerTree {

	private static HashMap<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {

		map.put("@001001", "20"); // number
		map.put("@001002", "1"); // choice, true or false as String ( 3. Dolor
									// abdominal característico)
		map.put("@001003", "1"); // choice, true or false as String ( 4.
									// Lipasa/Amilasa x3 limite superior)
		map.put("@001004", "1"); // choice, true or false as String ( 5. Estudio
									// de imagenes informa Pnacreatitis aguda?)
		map.put("@001005", "1"); // choice, true or false as String ( 6. Se
									// descarta consumo de OH agudo)
		map.put("@001006", "1"); // choice, true or false as String ( 7. Se
									// descarta cirguia abdominal abierta
									// previa)
		map.put("@001007", "1"); // choice true or false as String ( 8. Se
									// descarta cirugia bariatrica previa)
		map.put("@001008", "10.13"); // number ( 9. pH)
		map.put("@001009", "80.01"); // number ( 10. Presion arterial sistolica)
		map.put("@00100A", "1"); // choice true or false as String ( 11.
									// Responde a fluidos)
		map.put("@00100B", "83"); // number (PaO2 SOLO en pacientes con
									// requerimiento de O2)
		map.put("@00100C", "0.001"); // number (13. Oxigeno suplementario)
		map.put("@00100D", "1.2"); // number (14. Creatinina serica)
		map.put("@00100E", "1"); // choice true or false as String (15.
									// Ecografia abdominal con colelitiasis o
									// barro biliar?)
		map.put("@001010", "1"); // choice true or false as String (17. Se
									// descarta Colangitis aguda)
		map.put("@001011", "1"); // choice true or false as String (18. Se
									// descarta diagnostico previo de
									// Coledocolitiasis)
		map.put("@001012", "1"); // choice true or false as String (19. Se
									// descarta co-morbilidad que contraindique
									// colesistectomia)
		map.put("@129756", "1"); // choice true or false as String (20. Se
									// descarta patologia aguda o cronica
									// neurologica/psiquiatrica que impida al
									// paciente dar su consentimiento)
		map.put("@001013", "1"); // choice true or false as String (21. Se
									// descarta embarazo)
		map.put("@001014", "1"); // choice true or false as String (22. Paciente
									// firmo el consentimiento informado)

		String json = new String(
				"{\"type\":\"Text\",\"label\":\"23. Paciente cumple con los criterios\",\"description\":\"\",\"conditions\":"
						+ "[[\"Assign\",[\"?::\",[\"&&\",[\"<\",\"17\",\"@001001\"],[\"<\",\"@001001\",\"71\"],"
						+ "[\"||\",[\"&&\",\"@001002\",\"@001003\"],[\"&&\",\"@001002\",\"@001004\"],"
						+ "[\"&&\",\"@001003\",\"@001004\"]],[\"==\",\"@001005\",\"1\"],[\"==\",\"@001006\",\"1\"],"
						+ "[\"==\",\"@001007\",\"1\"],[\"<\",[\"+\",[\"?::\",[\"&&\",[\"<\",\"7.301\",\"@001008\"],"
						+ "[\"<\",\"90.01\",\"@001009\"]],\"0\",[\"&&\",[\"<\",\"7.301\",\"@001008\"],"
						+ "[\"<\",\"@001009\",\"90.01\"],[\"==\",\"@00100A\",\"1\"]],\"1\",\"2\"],"
						+ "[\"?::\",[\"<\",[\"*\",\"@00100B\",[\"/\",[\"?::\",[\"<\",\"@00100C\",\"0.01\"],\"0.21\","
						+ "[\"<\",\"@00100C\",\"2.01\"],\"0.25\",[\"<\",\"@00100C\",\"4.01\"],\"0.3\","
						+ "[\"<\",\"@00100C\",\"8.01\"],\"0.4\",\"0.5\"]]],\"301\"],\"2\","
						+ "[\"<\",[\"*\",\"@00100B\",[\"/\",[\"?::\",[\"<\",\"@00100C\",\"0.01\"]"
						+ ",\"0.21\",[\"<\",\"@00100C\",\"2.01\"],\"0.25\",[\"<\",\"@00100C\",\"4.01\"]"
						+ ",\"0.3\",[\"<\",\"@00100C\",\"8.01\"],\"0.4\",\"0.5\"]]],\"400\"],\"1\",\"0\"],"
						+ "[\"?::\",[\"<\",\"@00100D\",\"1.4\"],\"0\",\"1\"]],\"2\"],[\"==\",\"@00100E\",\"1\"],"
						+ "[\"==\",\"@001010\",\"1\"],[\"==\",\"@001011\",\"1\"],[\"==\",\"@001012\",\"1\"],"
						+ "[\"==\",\"@129756\",\"1\"],[\"==\",\"@001013\",\"1\"],[\"==\",\"@001014\",\"1\"]]"
						+ ",\"Si\",\"No\"]],[\"Disable\"]],\"options\":{},\"identifier\":\"3c9127\"}");
		
		
		
		
		/*json = new String(
				"{\"type\":\"Text\",\"label\":\"23. Paciente cumple con los criterios\",\"description\":\"\",\"conditions\":"
						+ "[[\"Assign\",[\"?::\",[\"&&\",\"0\",\"1\"]"
						+ ",[\"/\",\"10\",\"5\"],[\"+\",\"1\",\"1\"]]],[\"Disable\"]],\"options\":{},\"identifier\":\"3c9127\"}");
		
		
		json = new String(
				"{\"type\":\"Text\",\"label\":\"23. Paciente cumple con los criterios\",\"description\":\"\",\"conditions\":"
						+ "[[\"Assign\",[\"<\",[\"+\",[\"?::\",[\"&&\",[\"<\",\"7.301\",\"@001008\"],"
				+ "[\"<\",\"90.01\",\"@001009\"]],\"0\",[\"&&\",[\"<\",\"7.301\",\"@001008\"],"
				+ "[\"<\",\"@001009\",\"90.01\"],[\"==\",\"@00100A\",\"1\"]],\"1\",\"2\"],"
				+ "[\"?::\",[\"<\",[\"*\",\"@00100B\",[\"/\",[\"?::\",[\"<\",\"@00100C\",\"0.01\"],\"0.21\","
				+ "[\"<\",\"@00100C\",\"2.01\"],\"0.25\",[\"<\",\"@00100C\",\"4.01\"],\"0.3\","
				+ "[\"<\",\"@00100C\",\"8.01\"],\"0.4\",\"0.5\"]]],\"301\"],\"2\","
				+ "[\"<\",[\"*\",\"@00100B\",[\"/\",[\"?::\",[\"<\",\"@00100C\",\"0.01\"]"
				+ ",\"0.21\",[\"<\",\"@00100C\",\"2.01\"],\"0.25\",[\"<\",\"@00100C\",\"4.01\"]"
				+ ",\"0.3\",[\"<\",\"@00100C\",\"8.01\"],\"0.4\",\"0.5\"]]],\"400\"],\"1\",\"0\"],"
				+ "[\"?::\",[\"<\",\"@00100D\",\"1.4\"],\"0\",\"1\"]],\"2\"]],[\"Disable\"]],\"options\":{},\"identifier\":\"3c9127\"}");*/
		
		/*json = new String(
				"{\"type\":\"Text\",\"label\":\"23. Paciente cumple con los criterios\",\"description\":\"\",\"conditions\":"
						+ "[[\"Assign\",[\"&&\",[\"<\",\"7.301\",\"@001008\"],"
				+ "[\"<\",\"@001009\",\"90.01\"],[\"==\",\"@00100A\",\"1\"]]],[\"Disable\"]],\"options\":{},\"identifier\":\"3c9127\"}");*/
		
		Gson gson = new Gson();
		JsonObject jobject = gson.fromJson(json, JsonObject.class);
		JsonArray jArray = jobject.get("conditions").getAsJsonArray();
		System.out.print("json array: " + jArray.toString() + "\n");
		
		System.out.print("json array count: " + jArray.size() + "\n");
		if (jArray.size() > 0) {
			// conditions
			List<Object> conditions = new ArrayList<Object>(jArray.size());
			for (int x = 0; x < jArray.size(); x++) {
				Object jo = jArray.get(x);
				if (jo instanceof JsonArray) {
					// arguments
					List<Object> arguments = new ArrayList<>();
					// effect
					final int JSONArrayCount = ((JsonArray) jo).size();
					if (JSONArrayCount == 0) {
						throw new RuntimeException("Missing effect (expecting a string).");
						// return null;
					}
					System.out.println("Effect String: " + ((JsonArray) jo).get(0).getAsString());
					final int argumentsOffset = 1;
					int argumentsCount = 0;
					if (((JsonArray) jo).get(0).getAsString().equals("Assign")) {
						argumentsCount = 1;
					}
					final int predicateOffset = argumentsOffset + argumentsCount;
					List<Object> JSONArgumentsArrayList = gson.fromJson(((JsonArray) jo).toString(),
							new TypeToken<ArrayList<Object>>() {
							}.getType());
					List<Object> JSONArgumentsArraySubList = JSONArgumentsArrayList.subList(argumentsOffset,
							argumentsCount + 1);
					if (JSONArgumentsArraySubList.size() > 0) {
						Object expressionArray = JSONArgumentsArraySubList.get(0);
						
						System.out.println(expressionArray);
						System.out.println(func1(expressionArray, 0));
					}

				}
			}
		}

		List<Object> a = new ArrayList<>();
		List<Object> b = new ArrayList<>();
		List<Object> c = new ArrayList<>();
		List<Object> d = new ArrayList<>();
		List<Object> e = new ArrayList<>();
		List<Object> f = new ArrayList<>();

		c.add("+");
		c.add("4");
		c.add("2");
		c.add("1");

		e.add("<");
		e.add("3");
		e.add("4");
		e.add("5");

		f.add("==");
		f.add("4");
		f.add("4");
		f.add("4");

		b.add(">");
		b.add(c);
		b.add("9");
		b.add("4");

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

		List<Object> t = new ArrayList<>();

		z.add("==");
		z.add("1");
		z.add("2");
		x.add("?::");
		x.add(z);
		x.add("11");
		x.add("22");
		y.add("+");
		y.add(x);
		y.add("33");
		y.add("11");
		y.add("11");

		//System.out.print(a + "\n");

		/*
		 * System.out.println("RESULTADO="+func1(z, 0)); ======= t.add("+");
		 * t.add("1"); t.add("1"); t.add("1");
		 * 
		 * System.out.println("RESULTADO="+func1(z, 0)); >>>>>>> branch 'master'
		 * of https://github.com/creationexus/GerTree.git
		 * 
		 * System.out.println("RESULTADO="+func1(x, 0));
		 * 
		 * System.out.println("RESULTADO="+func1(y, 0));
		 */

		//System.out.println("RESULTADO=" + func1(a, 0));
		
		//System.out.println("RESULTADO=" + func1(b, 0));
		 
		/*
		 * System.out.println("RESULTADO=" + func1(a, 0));
		 * 
		 * System.out.println("RESULTADO=" + func1(c, 0));
		 * 
		 * System.out.println("RESULTADO=" + func1(e, 0));
		 * 
		 * System.out.println("RESULTADO=" + func1(f, 0));
		 * 
		 * System.out.println("RESULTADO=" + func1(t, 0));
		 */

	}

	/*
	 * public static Object func(Object o, Object r){ Object aux = null; List l;
	 * if(o instanceof List){ //System.out.println("o: "+o);
	 * //System.out.println("r: "+r); switch(((List)o).get(0).toString()){
	 * case("+"): //System.out.println("+"); //System.out.println(">"); l =
	 * (List)o; if(esHoja(l)){ // Es Hoja if(!o.equals(r)){ aux = func(r, r); }
	 * if(l instanceof List){ if(esMayorQue(l)){ aux = func(l, true); // Si uso
	 * solo un parametro y lo mando por la funcion, cuando llega al switch no
	 * entra en ningun caso ya que es solo un boolean }else{ aux = func(l,
	 * false); } }else{ aux = l; } //System.out.println("+l "+aux);
	 * 
	 * }else{ for(int i = 1; i < ((List)o).size(); i++){ if(((List) o).get(i)
	 * instanceof List){ aux = func(((List) o).get(i), ((List) o).get(i));
	 * }else{ aux = ((List) o).get(i); func(aux, aux); } } } break;
	 * 
	 * case("?::"): //System.out.println("?::"); //System.out.println(">"); l =
	 * (List)o; if(esHoja(l)){ // Es Hoja if(!o.equals(r)){ aux = func(r, r); }
	 * if(l instanceof List){ if(esMayorQue(l)){ aux = func(l, true); // Si uso
	 * solo un parametro y lo mando por la funcion, cuando llega al switch no
	 * entra en ningun caso ya que es solo un boolean }else{ aux = func(l,
	 * false); } }else{ aux = l; } //System.out.println("+l "+aux);
	 * 
	 * }else{ for(int i = 1; i < ((List)o).size(); i++){ if(((List) o).get(i)
	 * instanceof List){ aux = func(((List) o).get(i), ((List) o).get(i));
	 * }else{ aux = ((List) o).get(i); func(aux, aux); } } } break;
	 * 
	 * case(">"): //System.out.println(">"); l = (List)o; if(esHoja(l)){ // Es
	 * Hoja if(!o.equals(r)){ aux = func(r, r); return r; } if(l instanceof
	 * List){ if(esMayorQue(l)){ aux = func(l, true); // Si uso solo un
	 * parametro y lo mando por la funcion, cuando llega al switch no entra en
	 * ningun caso ya que es solo un boolean return true; }else{ aux = func(l,
	 * false); return false; } }else{ aux = l; } //System.out.println("+l "
	 * +aux);
	 * 
	 * }else{ for(int i = 1; i < ((List)o).size(); i++){ if(((List) o).get(i)
	 * instanceof List){ aux = func(((List) o).get(i), ((List) o).get(i));
	 * }else{ aux = ((List) o).get(i); func(aux, aux); } } }
	 * 
	 * break;
	 * 
	 * case("<"): //System.out.println("<"); l = (List)o; if(esHoja(l)){ // Es
	 * Hoja, penultimo nivel de objeto array sin array anidados
	 * if(!o.equals(r)){ aux = func(r, r); return r; } if(l instanceof List){
	 * if(esMenorQue(l)){ aux = func(l, true); return true; }else{ aux = func(l,
	 * false); return false; } }else{ aux = l; }
	 * 
	 * //System.out.println("+l "+aux);
	 * 
	 * }else{ for(int i = 1; i < ((List)o).size(); i++){ if(((List) o).get(i)
	 * instanceof List){ aux = func(((List) o).get(i), ((List) o).get(i));
	 * }else{ aux = ((List) o).get(i); func(aux, aux); } } } break; } }else{
	 * //System.out.println("RR1:"+o); // VALORES LOCALES DE RESPUESTA NO SON
	 * CAPTURADOS PORQUE NO ENTRAN EN LOS CASE, YA QUE NO CONTIENEN EL SIMBOLO
	 * //ESPECIAL EN LA PRIMERA POSICION return o; }
	 * //System.out.println("RR2:"+o); return o; }
	 */

	public static Object func1(Object o, Integer oN) {
		Object aux = null;
		List l = null;
		if (o instanceof List) {
			// OPERACIONES SOBRE RAMAS
			switch (((List) o).get(0).toString()) {
			case ("+"):
				oN += 1;
				Double sum = 0.0;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof List) {
						l = (List) ((List) o).get(i);
						
						
						
						aux = func1(l, oN);
						
						System.out.println("!!!!!!!!!!!!!!!+"+aux+" "+o);
						// RESPUESTA DE CONDICIONES INTERNAS
						sum += Double.valueOf(aux.toString());

					} else {
						aux = ((List) o).get(i);
						System.out.println("!!!!!!!!!!!!!!!+"+aux+" "+o);
						sum += Double.valueOf(aux.toString());
						//func1(aux, oN);
					}
				}
				System.out.println("+"+sum);
				return sum;
			case ("/"):
				oN += 1;
				Double div = 1.0;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof List) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						// RESPUESTA DE CONDICIONES INTERNAS
						div /= Double.valueOf(aux.toString());

					} else {
						aux = ((List) o).get(i);
						div /= Double.valueOf(aux.toString());
						//func1(aux, oN);
					}
				}
				return div;
			case ("*"):
				oN += 1;
				Double multi = 1.0;
				// System.out.println("+");
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof List) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						// RESPUESTA DE CONDICIONES INTERNAS
						multi *= Double.valueOf(aux.toString());

					} else {
						aux = ((List) o).get(i).toString().startsWith("@")?map.get(((List) o).get(i).toString()):((List) o).get(i).toString();
						multi *= Double.valueOf(aux.toString());
						//func1(aux, oN);
					}
				}
				System.out.println("*"+multi);
				return multi;
			case ("?::"):
				oN += 1;
				// System.out.println("?::");
				System.out.println("############################################################"+(List) o);
				for (int i = 1; i < ((List) o).size() - 1; i += 2) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						// RESPUESTA DE CONDICIONES INTERNAS
						if ((Boolean) aux) {
							// OBSOLETO: Considera solo 3 elementos 1:condicion
							// 2:true 3:false
							// Considera en posiciones impares las condiciones,
							// i+1 a la condicion es TRUE y ultimo es FALSE
							//return ((List) o).get(i + 1).toString();
							//System.out.println(">>>>>>>>>><"+((List) o).get(i + 1).toString());
							System.out.println("############################################################TRUE+"+((List) o).get(i + 1));
							return func1(((List) o).get(i + 1), oN);
						}
					} else {
						aux = ((List) o).get(i);
						//func1(aux, oN);
					}
				} // NINGUNA CONDICION FUE TRUE ENTONCES RETORNA LA ULTIMA
					// POSICION
				System.out.println("############################################################FALSE+"+((List) o).get(((List) o).size() - 1));
				return func1(((List) o).get(((List) o).size() - 1), oN);
			case (">"):
				oN += 1;
				Double menor = 0.0;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						if(i==1)
							menor = Double.valueOf(aux.toString());
						if(menor<=(Double)aux){
							return false;
						}else{
							menor = (Double)aux;
						}
					} else {
						aux = ((List) o).get(i).toString().startsWith("@")?Double.valueOf(map.get(((List) o).get(i).toString()).toString()):Double.valueOf(((List) o).get(i).toString());
						if(i==1)
							menor = Double.valueOf(aux.toString()); 
						if(menor<=(Double)aux){
							return false;
						}else{
							menor = (Double)aux;
						}
						//func1(aux, oN);
					}
				}
				return true;

			case ("<"):
				oN += 1;
				Double mayor = 0.0;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						if(mayor>=(Double)aux){
							System.out.println("<"+((List) o)+"----------- FALSE");							
							return false;
						}else{
							mayor = (Double)aux;
						}
					} else {
						aux = ((List) o).get(i).toString().startsWith("@")?Double.valueOf(map.get(((List) o).get(i).toString()).toString()):Double.valueOf(((List) o).get(i).toString());
						if(mayor>=(Double)aux){
							System.out.println("<"+((List) o)+"----------- FALSE");
							return false;
						}else{
							mayor = (Double)aux;
						}
						//func1(aux, oN);
					}
				}
				
				System.out.println("<"+((List) o)+" true");
				return true;
			case ("=="):
				oN += 1;
				// System.out.println("<");
				Object eq = 0.0;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = Double.valueOf(func1(l, oN).toString());
						
						if(i==1)
							eq = aux.toString().startsWith("@")?map.get(aux.toString()):aux;
						if(!eq.equals(aux)){
							return false;
						}
					} else {
						aux = ((List) o).get(i).toString().startsWith("@")?map.get(((List) o).get(i).toString()):((List) o).get(i);
						if(i==1)
							eq = aux.toString().startsWith("@")?map.get(aux.toString()):aux;
						if(!eq.equals(aux)){
							return false;
						}
						//func1(aux, oN);
					}
				}
				return true;
			case ("&&"):
				oN += 1;
				Boolean and = true;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						aux = aux.toString().startsWith("@")?map.get(aux.toString()).toString():aux.toString();
						if(aux.toString().startsWith("0")||aux.toString().startsWith("1"))
							and = and&&Boolean.valueOf(aux.toString().compareTo("1")==0?true:false);
						else
							and = and&&Boolean.valueOf(aux.toString());
					} else {
						aux = ((List) o).get(i).toString().startsWith("@")?map.get(((List) o).get(i).toString()).toString():((List) o).get(i).toString();
						
						if(aux.toString().startsWith("0")||aux.toString().startsWith("1"))
							and = and&&Boolean.valueOf(aux.toString().compareTo("1")==0?true:false);
						else
							and = and&&Boolean.valueOf(aux.toString());
						//func1(aux, oN);
					}
				}
				System.out.println("AND ==============="+and+o);
				return and;
			case ("||"):
				oN += 1;
				Boolean or = false;
				for (int i = 1; i < ((List) o).size(); i++) {
					if (((List) o).get(i) instanceof ArrayList) {
						l = (List) ((List) o).get(i);
						aux = func1(l, oN);
						if(aux.toString().startsWith("0")||aux.toString().startsWith("1"))
							or = or||Boolean.valueOf(aux.toString().compareTo("1")==0?true:false);
						else
							or = or||Boolean.valueOf(aux.toString());
					} else {
						aux = ((List) o).get(i);
						if(aux.toString().startsWith("0")||aux.toString().startsWith("1"))
							or = or||Boolean.valueOf(aux.toString().compareTo("1")==0?true:false);
						else
							or = or||Boolean.valueOf(aux.toString());
						//func1(aux, oN);
					}
				}
				System.out.println("|| ========="+or+" "+o);
				return or;
			}
		} else {
			// System.out.println("RR1:"+o); // VALORES LOCALES DE RESPUESTA NO
			// SON CAPTURADOS PORQUE NO ENTRAN EN LOS CASE, YA QUE NO CONTIENEN
			// EL SIMBOLO
			// ESPECIAL EN LA PRIMERA POSICION
			if(String.valueOf(o).indexOf("@")==0){
				return map.get(o.toString());
			}
			
			return o;
		}
		// OPERACIONES DE RESOLUCION DE HOJAS
		System.out.println(oN + "====== " + o);
		List lR = (List) o;
		switch (lR.get(0).toString()) {
		case ("<"): //StrictlyAscending
			Double menor;
			menor = (lR.get(1).toString().startsWith("@")) ? Double.valueOf((String) map.get(lR.get(1)))
					: Double.valueOf(lR.get(1).toString());
			if (menor == null) {
				throw new RuntimeException("number [<][Menor] is null");
			}
			for (int i = 1; i < lR.size(); i++) {
				Double evaluar;
				evaluar = (lR.get(i).toString().startsWith("@")) ? Double.valueOf((String) map.get(lR.get(i)))
						: Double.valueOf(lR.get(i).toString());
				if (evaluar == null) {
					throw new RuntimeException("number [<][Evaluar] is null");
				}
				// System.out.print("Evaluar: "+evaluar);
				if (menor > evaluar) {
					return false;
				} else {
					menor = evaluar;
				}
			}
			return true;
		case (">"): //StrictlyDescending
			Double mayor = (double) 0;
			for (int i = 1; i < lR.size(); i++) {
				if (Double.valueOf(lR.get(i).toString()) < mayor) {
					return false;
				} else {
					mayor = Double.valueOf(lR.get(i).toString());
				}
			}
			return true;
		case ("=="):
			Double igual = (lR.get(1).toString().startsWith("@")) ? Double.valueOf((String) map.get(lR.get(1)))
					: Double.valueOf(lR.get(1).toString());
			for (int i = 1; i < lR.size(); i++) {
				Double compareTo = (lR.get(i).toString().startsWith("@")) ? Double.valueOf((String) map.get(lR.get(i)))
						: Double.valueOf(lR.get(i).toString());
				if (!compareTo.equals(igual)) {
					return false;
				} else {
					igual = compareTo;
				}
			}
			return true;
		case ("+"):
			Double suma = (double) 0;
			for (int i = 1; i < lR.size(); i++) {
				suma += Double.valueOf(lR.get(i).toString());
			}
			return suma;
		case ("*"):
			Double multi = (double) 1;
			for (int i = 1; i < lR.size(); i++) {
				multi *= Double.valueOf(lR.get(i).toString());
			}
			return multi;
		case ("/"):
			Double div = (double) 1;
			for (int i = 1; i < lR.size(); i++) {
				div = Double.valueOf(lR.get(i).toString()) / div;
			}
			return div;
		default:
			return o;
		}
		
		//}
		//return o;
	}

	public static Boolean esHoja(List l) {
		for (int i = 1; i < l.size(); i++) {
			if (l.get(i) instanceof List) {
				return false;
			}
		}
		return true;
	}

	public static Boolean esMenorQue(List l) {
		Integer min = Integer.valueOf(l.get(1).toString());
		for (int i = 2; i < l.size(); i++) {
			Integer value = Integer.valueOf(l.get(i).toString());
			if (value > min) {
				return false;
			} else {
				min = value;
			}
		}
		return true;
	}

	public static Boolean esMayorQue(List l) {
		int max = 0;
		for (int i = 1; i < l.size(); i++) {
			Integer value = Integer.valueOf(l.get(i).toString());
			if (value < max) {
				return false;
			} else {
				max = value;
			}
		}
		return true;
	}

}