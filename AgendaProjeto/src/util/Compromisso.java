package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compromisso {

	private String name;
	private LocalDate data;
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Compromisso() {
	}

	public Compromisso(String name, LocalDate data) {
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public DateTimeFormatter getFmt() {
		return fmt;
	}

	public void setFmt(DateTimeFormatter fmt) {
		this.fmt = fmt;
	}

	@Override
	public String toString() {
		return "Compromisso: " + name + ", data: " + data.format(fmt);
	}

}