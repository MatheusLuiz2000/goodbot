package br.com.fiap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "TB_BOT")
public class BotModel {

	private long id_bot;
	private String name;
	private String welcome_msg;
	private String farewell_msg;
	private int downtime;
	private String default_answer;
	private List<SegmentoModel> segmentos;
	
	
	public BotModel() {
		super();
	}
	
	public BotModel(long id_bot, String name, String welcome_msg, String farewell_msg, int downtime,
			String default_answer) {
		super();
		this.id_bot = id_bot;
		this.name = name;
		this.welcome_msg = welcome_msg;
		this.farewell_msg = farewell_msg;
		this.downtime = downtime;
		this.default_answer = default_answer;
	}
	
	@Id
	@Column(name = "ID_BOT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOT_SEQ")
	@SequenceGenerator(name = "BOT_SEQ", sequenceName = "BOT_SEQ", allocationSize = 1)
	public long getId_bot() {
		return id_bot;
	}
	public void setId_bot(long id) {
		this.id_bot = id;
	}
	
	@Column(name = "NAME")
	@NotNull(message = "Campo nome é obrigatório")
	@Size(min = 1, max = 100, message = "O name deve possuir entre 1 a 100 caracteres.")
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	@Column(name = "WELCOME_MSG")
	@NotNull(message = "Campo welcome mensage é obrigatório")
	@Size(min = 2, max = 50, message = "O welcome mensage deve possuir entre 1 a 100 caracteres.")
	public String getWelcome_msg() {
		return welcome_msg;
	}
	public void setWelcome_msg(String welcome_msg) {
		this.welcome_msg = welcome_msg;
	}
	
	@Column(name = "FAREWELL_MSG")
	@NotNull(message = "Campo farewell msg é obrigatório")
	@Size(min = 1, max = 100, message = "O farewell msg deve possuir entre 1 a 100 caracteres")
	public String getFarewell_msg() {
		return farewell_msg;
	}
	public void setFarewell_msg(String farewell_msg) {
		this.farewell_msg = farewell_msg;
	}
	
	@Column(name = "DOWNTIME")
	@NotNull(message = "Campo de downtime é obrigatório")
	@Max(999)
	@Min(1)
	public int getDowntime() {
		return downtime;
	}
	public void setDowntime(int downtime) {
		this.downtime = downtime;
	}
	
	@Column(name = "DEFAULT_ANSWER")
	@NotNull(message = "Campo de default answer é obrigatório")
	@Size(min = 1, max = 255, message = "O default answer deve possuir entre 1 a 255 caracteres")
	public String getDefault_answer() {
		return default_answer;
	}
	public void setDefault_answer(String default_answer) {
		this.default_answer = default_answer;
	}

	@OneToMany(mappedBy = "bot")
	public List<SegmentoModel> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<SegmentoModel> segmentos) {
		this.segmentos = segmentos;
	}
	
	
	
	
}
