package com.sharankonda.elevatorrestapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharankonda.elevatorrestapp.Building.Building;
import com.sharankonda.elevatorrestapp.Types.BuildingType;
import com.sharankonda.elevatorrestapp.Types.DisplayType;
import com.sharankonda.elevatorrestapp.Types.MoveLiftType;
import com.sharankonda.elevatorrestapp.Types.RequestLiftType;

@RestController
public class APIController {
	private Building building;

	// private final AtomicLong counter = new AtomicLong();

	@CrossOrigin(origins = "*")
	@PostMapping("/initializeBuilding")
	public BuildingType createBuiling(@RequestBody BuildingType buildingInpObj) {
		try {
			this.building = new Building(buildingInpObj.getFloors(), buildingInpObj.getElevators(),
					buildingInpObj.getLiftSpeed());
			buildingInpObj.setStatus("SUCCESS");
		} catch (Exception e) {
			buildingInpObj.setStatus("FAIL");
		}

		return buildingInpObj;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/lifts")
	public DisplayType[] getLifts() {
		return this.building.getLifts();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/lifts/request")
	public RequestLiftType requestLift(@RequestBody RequestLiftType requestLiftObj) {
		try {
			this.building.requestLift(requestLiftObj.getFloor(), requestLiftObj.getDirection());
			requestLiftObj.setStatus("SUCCESS");
		} catch (Exception e) {
			requestLiftObj.setStatus("FAIL");
		}

		return requestLiftObj;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/lifts/move")
	public MoveLiftType moveLift(@RequestBody MoveLiftType moveLiftObj) {
		try {
			this.building.goToFloorByLift(moveLiftObj.getFloor(), moveLiftObj.getElevator());
			moveLiftObj.setStatus("SUCCESS");
		} catch (Exception e) {
			moveLiftObj.setStatus("FAIL");
		}

		return moveLiftObj;
	}
}