class AutoTurnOn extends TimerTask{
 	public void run {
 		if (!from.inShock) {
 			device.getPin(9).setMode(Pin.Mode.OUTPUT);
 			device.getPin(9).setValue(350);
 			device.getpin(11).setMode(Pin.Mode.INPUT);
 			Thread.sleep(50);

 			device.getPin(9).setMode(Pin.Mode.INPUT);
 		}
 	}
 }

 class ArdConnect{
 	public static void startAutoTurnOnTimer(){
 		Timer timer = new Timer();
 		TimerTask task = new AutoTurnOn(); 
 		timer.schedule(task, 0, 30000); 
 	}

 	public static void sendShock( int time) {
 		from.inShock = true;
 		IODevice device = new FirmtaDevice("Com4");
 		device.start();
 		divice.ensureInitializationIsDone();

 		try{
 			

 			device.getPin(1).setMode(Pin.Mode.OUTPUT);
 			device.getPin(1).setValue(350);
 			device.getpin(3).setMode(Pin.Mode.INPUT);

 			Thread.sleep(time*50)

 			device.getPin(1).setMode(Pin.Mode.INPUT);

 			
 		} catch (IOException e){
 			e.printStackTrace();
 		}
		from.inShock = false;
 	}


 }

