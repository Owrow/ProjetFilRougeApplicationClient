package bo;

public class Role {

	private int id;
	private String libelle;

	public Role() {
	}

	public Role(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", libelle=" + libelle + "]";
	}
}
