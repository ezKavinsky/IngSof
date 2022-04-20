package TextDocExample.src.is.textdoc.json.old;

import TextDocExample.src.is.textdoc.builder.DocumentBuilder;

import java.io.PrintWriter;

public class JSONTextConverter implements DocumentBuilder {
	private PrintWriter pw;
	private int indentLev=0;
	private boolean firstSec=false;
	private boolean firstSub=false;
	private boolean firstPar=false;

   
	private void indent(){
		for(int i=0;i<indentLev;++i)
		pw.print("    ");
	}
	public JSONTextConverter(PrintWriter pw) {
		this.pw=pw;
	}
	
	@Override
	public void openDocument(String title) {
		pw.println("{\"document\": {");
		indentLev++;
		indent();
		pw.print("\"title\": \"");
		pw.print(title.trim());
		pw.println("\",");
		
		indent();
		pw.println("\"content\": [");
		indentLev++;
		firstSec=true;
	}

	@Override
	public void closeDocument() {
		pw.println();
		indentLev--;
		indent();
		pw.println(']');
		indentLev--;
		pw.println("}}");
		pw.flush();
	}

	@Override
	public void openSection(String title) {
		if(firstSec){
			firstSec=false;
		}else pw.println(",");
		indent();
		pw.println("{\"section\":{");
		indentLev++;
		indent();
		pw.print("\"title\": \"");
	
		pw.print(title.trim());
		pw.println("\",");
		indent();
		pw.println(" \"content\": [");
		indentLev++;
		firstSub=true;
	}

	@Override
	public void addParagraph(String text) {
		if(firstSub){
			firstSub=false;
		}else if(firstPar){
			firstPar=false;
		}else pw.println(",");
		indent();
		pw.print("{\"par\":\"");
		
		
	
		pw.print(text.trim());
		pw.print("\"");
		pw.print("}");
	}
	@Override
	public void closeSection() {
		indentLev--;
		indent();
		pw.println(" ]");
	
		indentLev--;
		indent();
		pw.print("}}");
	
	}

	@Override
	public void openSubsection(String title) {
		if(firstSub){
			firstSub=false;
		}else pw.println(",");
		indent();
		pw.println("{\"subsection\":{");
		indentLev++;
		indent();
		pw.print("\"title\": \"");
	
		pw.print(title.trim());
		pw.println("\",");
		indent();
		pw.println(" \"content\": [");
		indentLev++;
		firstPar=true;
	}

	@Override
	public void closeSubsection() {
		indentLev--;
		indent();
		pw.println(" ]}");
	
		indentLev--;
		indent();
		pw.print("}");
	}

}
