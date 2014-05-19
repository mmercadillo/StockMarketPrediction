package pl.edu.pw.mini.msi.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import pl.edu.pw.mini.msi.ClientDialog;
import pl.edu.pw.mini.msi.patterns.Pattern;
import pl.edu.pw.mini.msi.patterns.PatternSet;

public class PatternParser implements ActionListener {
	ClientDialog context;
	ArrayList<StockPrice> data;

	public PatternParser(ClientDialog context, ArrayList<StockPrice> data) {
		this.context = context;
		this.data = data;
	}

	public Pattern findPattern() {
		Pattern best = null;
		double max = -1;

		for (Pattern pattern : PatternSet.instance()) {
			double tmp;
			if ((tmp = pattern.matchData(data)) > max) {
				max = tmp;
				best = pattern;
			}
		}

		return best;
	}

	public void setData(ArrayList<StockPrice> data) {
		this.data = data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		context.displayAnswer(findPattern());
	}
}