/**
 * 
 */
package com.extension.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.extension.entity.Applicationkey;
import com.extension.repository.VerifyKeysRepository;
import com.extension.service.RegisterKeyService;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class RegisterKeyServiceImpl implements RegisterKeyService {

	@Autowired
	private VerifyKeysRepository verifyRepository;

	@Transactional
	private boolean updateKeyDate(String deviceName, String key) {
		try {
			if (!verifyRepository.findByKey(key).isActivated()) {
				Applicationkey device = verifyRepository.findByKey(key);
				Calendar registerDay = Calendar.getInstance();
				Calendar endDay = Calendar.getInstance();
				endDay.set(Calendar.DATE, registerDay.get(Calendar.DATE) + 90);
				device.setActivatedDate(registerDay.getTime());
				device.setEndDate(endDay.getTime());
				device.setDeviceName(deviceName);
				device.setActivated(true);
				if (verifyRepository.save(device) != null) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean registerDevice(String deviceName, String key) {
		try {
			if (verifyRepository.findByDeviceName(deviceName) == null) {
				if (updateKeyDate(deviceName, key)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
