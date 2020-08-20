/**
 * 
 */
package com.extension.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.extension.entity.Applicationkey;

/**
 * @author KhanhBQ3
 *
 */
public interface VerifyKeysRepository extends MongoRepository<Applicationkey, String> {
	Applicationkey findByKey(String key);

	Applicationkey findByDeviceName(String deviceName);

	Applicationkey findByDeviceNameAndKey(String deviceName, String key);
}
