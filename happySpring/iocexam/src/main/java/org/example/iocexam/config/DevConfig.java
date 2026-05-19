package org.example.iocexam.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Profile;

@Configurable
@Profile("dev")
public class DevConfig {
}
