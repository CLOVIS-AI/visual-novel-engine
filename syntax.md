# Architecture

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

		stage-version 1
		stage Name of the stage
		
		label LABEL
		line CHARACTER_NAME My God ! What was that scream ?

		background path/to/pic
		
		var first 2
		add first 1
		rm first 1
		
		choice What should I do ?
		choose next Enter the room
		choose stage:STAGE_NAME Go back
		choose chapt:CHAPT_NAME Wait a bit
		choose end:END_NAME Jump through the window
		choose label:THERE Something else

		test first equals 2
		success stage:STAGE_NAME
		failure stage:STAGE_NAME



# Creating new commands

 1. Register the command (name, parameters, action) : "Command" object
 2. Loading of the story : creating every "Line" object
