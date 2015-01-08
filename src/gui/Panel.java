package gui;
import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PFont;

public class Panel {
	private static final int DEFAULT_FONT_COLOR = 0xffffffff;
	private List<PanelItem> tuples;
	private float x, y;
	private PFont f;
	PApplet p;
	private int fontColor = DEFAULT_FONT_COLOR;

	public Panel(PApplet p, float x, float y) {
		this.p = p;
		this.x = x;
		this.y = y;
		tuples = new LinkedList<PanelItem>();
		f = p.createFont("Verdana", 12, false);
	}
	
	public void setFontColor(int color) { fontColor  = color; }

	public void draw() {
		float cy = this.y;
		p.fill(fontColor);
		for (PanelItem t: tuples) {
			p.textFont(f);
			float ascent = p.textAscent();
			p.text(t.getString(), x, cy + ascent);
			cy += ascent;
		}
	}

	public void addItem(PanelItem pi) { tuples.add(pi); }
}