/**
 * 
 */
package com.extension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extension.service.RegisterKeyService;

/**
 * @author KhanhBQ3
 *
 */
@RestController
@RequestMapping("/api/v1/register")
public class RegisterKeyController {

	@Autowired
	private RegisterKeyService keyService;

	@GetMapping(path = "/r/{device}/{key}")
	public boolean registerKey(@PathVariable("device") String deviceName, @PathVariable("key") String key) throws Exception {
		return keyService.registerDevice(deviceName, key);
	}
	
}
