# Architecture

		./vne		
			progress.txt

		Story
			settings.txt
			actors/
				actor1/
					data.txt
					lines/
					avatars/	
				actor2/
			images/
				backgrounds/
				screens/
			chapters/
				chapter1/
					settings.txt
					stage1.txt
					stage2.txt
				chapter2/
			endings/
				ending1.txt
			sounds/
				musics/
				effects/


# Objects

		Chapter
			List of Stages
		
		Stage
			List of Commands
			Class Ending

		Command
			Class Version
			Class Label
		
		Actor
			Name
			Picture

		Story
			List of Chapters

# Stage

		STAGE|1|Name of the stage
		
		label LABEL
		line CHARACTER_NAME My God ! What was that scream ?

		screen path/to/pic
		
		background path/to/pic
		
		set first 2
		add first 1
		rmv first 1
		
		choose What should I do ?
		choice stg:STAGE_NAME Go back
		choice chp:CHAPT_NAME Wait a bit
		choice end:END_NAME Jump through the window
		choice lbl:THERE Something else

		equals first 2
		success stg:STAGE_NAME
		failure end:STAGE_NAME

	NOTE: Overloading of commands is authorized BUT the number of parameters MUST be the same


# Creating new commands

 1. Register the command (name, parameters, action) : "Command" object
 2. Loading of the story : creating every "Line" object

# Load a stage

 1. Read through the file and split by line
 2. Parse each line and check if they correspond to a Command ; if they do, instantiate the Argument and store it in a Line object along with the Commands' lambda
 3. Execute each Line's lambda with the provided arguments
