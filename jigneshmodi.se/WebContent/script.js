var wheel =document.getElementsByClassName('wheel')[0];
var dart =document.getElementsByClassName('dart')[0];
var transition = 'top .8s cubic-bezier(0.77, 0, 0.175, 1)';
var sections= document.getElementsByClassName('section');
var page =document.getElementsByClassName('page')[0];
var segmentNo;

function hitme() {
	console.log( 'under hit me! ' );
	dart.style.animation="throwDart 1.5s linear";
	window.setTimeout( pauseWheel , 450);

}
 function pauseWheel() {
 	if("paused" !== wheel.style.animationPlayState ) {
		wheel.style.animationPlayState ="paused";
		matrix = window.getComputedStyle(wheel).getPropertyValue('transform');
		offsetTop = matrixToDegree( matrix );
		$('body').stop().animate( {scrollTop: offsetTop } ,1000);
		window.setTimeout( resetAnimation , 2000 );
	}
	else
	 wheel.style.animationPlayState ="running";
	}
		
	function resetAnimation() {
		dart.style.animation="";
		wheel.style.animationPlayState ="running";
	}
	
	setInterval( matrixToDegree, 1000);
	function matrixToDegree( ) {
		matrix = window.getComputedStyle(wheel).getPropertyValue('transform');
		console.log( 'matrixToDegree' ); 
		var values = matrix.split('(')[1];
		    values = values.split(')')[0];
		    values = values.split(',');
		var a = values[0];
		var b = values[1];
		var c = values[2];
		var d = values[3];

		// arc sin, convert from radians to degrees, round
		// DO NOT USE: see update below
		if( a>0 & b<0)  segmentNo = 0; //about us
		if( a<0 & b<0)  segmentNo = 1;  //past experience
		if( a>0 & b>0)  segmentNo = 2;   //contant us
		if( a<0 & b>0)  segmentNo = 3;  //feedback
		// works!
		return sections[segmentNo].offsetTop;
	}
	

	
