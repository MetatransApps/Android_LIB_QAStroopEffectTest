package org.metatrans.apps.stroop.logic;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;

import org.metatrans.apps.stroop.lib.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion;
import org.metatrans.commons.questionnaire.api.IConfigurationQuestion_TextQuestion;
import org.metatrans.commons.questionnaire.api.IQuestionGenerator;
import org.metatrans.commons.questionnaire.model.GameData;
import org.metatrans.commons.questionnaire.utils.NumbersUtils;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class QuestionGenerator_Colours_Impl implements IQuestionGenerator {
	
	
	private Context context;
	
	
	private static final int[] colours_images = new int[] {
			R.drawable.ic_arc_comp_red,
			R.drawable.ic_arc_comp_orange,
			R.drawable.ic_arc_comp_yellow,
			R.drawable.ic_arc_comp_green,
			R.drawable.ic_arc_comp_blue,
			//R.drawable.ic_arc_comp_indigo,
			R.drawable.ic_arc_comp_violet,
		};


	private static final int[] colours_codes = new int[] {
			Color.rgb(255, 0, 0),
			Color.rgb(255, 127, 0),
			Color.rgb(255, 255, 0),
			Color.rgb(0, 255, 0),
			Color.rgb(0, 0, 255),
			//Color.rgb(122, 0, 229),
			Color.rgb(211, 0, 201),
		};
	
	private static final int[] colours_names = new int[] {
			R.string.ec_colour_red,
			R.string.ec_colour_orange,
			R.string.ec_colour_yellow,
			R.string.ec_colour_green,
			R.string.ec_colour_blue,
			//R.string.ec_colour_indigo,
			R.string.ec_colour_violet,
		};
	
	
	private int[] indexes = new int[] {0, 1, 2, 3, 4, 5/*, 6*/};
	
	
	public QuestionGenerator_Colours_Impl(Context _context) {
		context = _context;
	}
	
	
	@Override
	public IConfigurationQuestion nextQuestion(GameData gameData) {
		
		
		NumbersUtils.shuffleArray(indexes);

		String bitmap_text_str = context.getString(colours_names[indexes[0]]) + "";

		int color_background = colours_codes[indexes[1]];

		//System.out.println("bitmap_text_str=" + bitmap_text_str);


		IConfigurationQuestion question = new CfgQuestion_Colours_Image(

			0,

						new Integer[] {

								colours_codes[indexes[0]],
								colours_codes[indexes[1]],
								colours_codes[indexes[2]],
								colours_codes[indexes[3]]
						},

						bitmap_text_str,

						color_background
		);

		
		question.shuffle();


		return question;
	}
}

