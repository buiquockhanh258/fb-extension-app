/**
 * 
 */
package com.extension.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extension.repository.VerifyKeysRepository;
import com.extension.service.RegisterKeyService;
import com.extension.service.VerifyKeyService;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class VerifyKeyServiceImpl implements VerifyKeyService {

	@Autowired
	private VerifyKeysRepository verifyRepository;

	@Autowired
	RegisterKeyService register;

	@Override
	public boolean verifyKey(String deviceName, String key) throws Exception {
		try {
			if (verifyRepository.findByDeviceNameAndKey(deviceName, key).isActivated()) {
				return true;
			} else {
				try {
					if (register.registerDevice(deviceName, key)) {
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		} catch (Exception e) {
			if (register.registerDevice(deviceName, key)) {
				return true;
			} else {
				return false;
			}
		}
	}

}