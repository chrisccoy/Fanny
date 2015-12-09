package fanny;

import java.util.List;

public class PlayerPool {
	
	private List <Player>qb;
	private List <Player>wr;
	private List <Player>rb;
	private List <Player>te;
	private List <Player>k;
	private List <Player>dst;
	public List<Player> getQb() {
		return qb;
	}
	public void setQb(List<Player> qb) {
		this.qb = qb;
	}
	public List<Player> getWr() {
		return wr;
	}
	public void setWr(List<Player> wr) {
		this.wr = wr;
	}
	public List<Player> getRb() {
		return rb;
	}
	public void setRb(List<Player> rb) {
		this.rb = rb;
	}
	public List<Player> getTe() {
		return te;
	}
	public void setTe(List<Player> te) {
		this.te = te;
	}
	public List<Player> getK() {
		return k;
	}
	public void setK(List<Player> k) {
		this.k = k;
	}
	public List<Player> getDst() {
		return dst;
	}
	public void setDst(List<Player> dst) {
		this.dst = dst;
	}
}
