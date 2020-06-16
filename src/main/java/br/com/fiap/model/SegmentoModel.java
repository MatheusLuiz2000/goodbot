package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_SEGMENT")
public class SegmentoModel {

	private long id_segment;
	private String name;
	private BotModel bot;
	
	
	public SegmentoModel() {
	}
	
	public SegmentoModel(long id_segment, String name, BotModel bot) {
		super();
		this.id_segment = id_segment;
		this.name = name;
		this.bot = bot;
	}
	
	@Id
	@Column(name = "id_segment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEGMENT_SEQ")
	@SequenceGenerator(name = "SEGMENT_SEQ", sequenceName = "SEGMENT_SEQ", allocationSize = 1)
	public long getId_segment() {
		return id_segment;
	}
	public void setId_segment(long id_segment) {
		this.id_segment = id_segment;
	}
	
	@Column(name = "name")
	@NotNull(message = "Campo name é obrigatório")
	@Size(min = 1, max = 100, message = "O name deve possuir entre 1 a 100 caracteres.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_BOT", nullable = false)
	public BotModel getBot() {
		return bot;
	}
	public void setBot(BotModel bot) {
		this.bot = bot;
	}
	
	
	
}
