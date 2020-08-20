/**
 * 
 */
package com.extension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extension.entity.Applicationkey;
import com.extension.repository.VerifyKeysRepository;
import com.extension.service.VerifyKeyService;

/**
 * @author KhanhBQ3
 *
 */
@RestController
@RequestMapping("/api/v1")
public class VerifyKeyController {

	@Autowired
	private VerifyKeyService verifyKeyService;

	@Autowired
	private VerifyKeysRepository repository;

	@GetMapping(path = "/verify/{deviceName}/{key}")
	public Applicationkey verify(@PathVariable("deviceName") String deviceName, @PathVariable("key") String key) {
		try {
			if (verifyKeyService.verifyKey(deviceName, key)) {
				return repository.findByDeviceNameAndKey(deviceName, key);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}