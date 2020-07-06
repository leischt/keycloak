/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.userprofile.profile.represenations;

import org.keycloak.models.UserModel;
import org.keycloak.userprofile.profile.AbstractUserProfile;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:markus.till@bosch.io">Markus Till</a>
 */
public class UserModelUserProfile extends AbstractUserProfile {

    private final UserModel user;

    public UserModelUserProfile(UserModel user) {
        this.user = user;
    }

    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        return user.getAttributes();
    }

    @Override
    public void setAttribute(String key, List<String> value) {
        user.setAttribute(key, value);
    }

    @Override
    public void removeAttribute(String attr) {
        // Due to the fact that the user attribute list is a copy and not a reference in the user adapter we have to access the remove function directly
        user.removeAttribute(attr);
    }
}
