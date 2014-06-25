package com.sedc.example1;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mainact;
	private TextView text;
	private EditText edittxt;
	private Button button;
	
	
	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		setActivityInitialTouchMode(true);
		mainact = this.getActivity();
		
		edittxt = (EditText)mainact.findViewById(R.id.enteredittxt);
		text = (TextView)mainact.findViewById(R.id.yourtext);
		button = (Button)mainact.findViewById(R.id.clickbtn);
		
	}
	
	@SmallTest
	public void testViews() {
	assertNotNull(getActivity());
	}
	
	@SmallTest
	public void testMethod1()
	{
		String enteredtext;
		edittxt.clearComposingText();
		TouchUtils.tapView(this, edittxt);
		
		sendKeys("hello");
		
		TouchUtils.clickView(this, button);
		
		try
		{
			enteredtext = text.getText().toString();
		}
		catch(Exception ex)
		{
			enteredtext = "";
		}
		
		assertEquals("hello", enteredtext);
	}
	

}
