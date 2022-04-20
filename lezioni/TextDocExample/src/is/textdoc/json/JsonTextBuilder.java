package TextDocExample.src.is.textdoc.json;

import TextDocExample.src.is.textdoc.builder.DocumentBuilder;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.PrintWriter;

public class JsonTextBuilder implements DocumentBuilder {
	JsonGenerator gen;

	public JsonTextBuilder(PrintWriter pw) {

		gen = Json.createGenerator(pw);

	}

	@Override
	public void openDocument(String title) {
		gen.writeStartObject().writeStartObject("document")
				.write("title", title.trim());
		gen.writeStartArray("content");

	}

	@Override
	public void closeDocument() {
		gen.writeEnd();
		gen.writeEnd().writeEnd();
		gen.close();
	}

	@Override
	public void openSection(String title) {
		gen.writeStartObject().writeStartObject("section")
				.write("title", title.trim());
		gen.writeStartArray("content");

	}

	@Override
	public void addParagraph(String text) {
		gen.writeStartObject().write("par", text.trim()).writeEnd();
	}

	@Override
	public void closeSection() {
		gen.writeEnd();
		gen.writeEnd().writeEnd();

	}

	@Override
	public void openSubsection(String title) {
		gen.writeStartObject().writeStartObject("subsection")
				.write("title", title.trim());
		gen.writeStartArray("content");

	}

	@Override
	public void closeSubsection() {
		gen.writeEnd();
		gen.writeEnd().writeEnd();
	}

}
