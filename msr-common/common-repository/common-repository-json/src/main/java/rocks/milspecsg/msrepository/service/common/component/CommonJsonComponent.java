/*
 *     MSRepository - MilSpecSG
 *     Copyright (C) 2019 Cableguy20
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package rocks.milspecsg.msrepository.service.common.component;

import io.jsondb.JsonDBOperations;
import rocks.milspecsg.msrepository.api.component.Component;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;

import java.util.Optional;
import java.util.UUID;

public interface CommonJsonComponent extends Component<UUID, JsonDBOperations, JsonConfig> {

    @Override
    default Optional<UUID> parse(Object object) {
        if (object instanceof UUID) {
            return Optional.of((UUID) object);
        } else if (object instanceof Optional<?>) {
            Optional<?> optional = (Optional<?>) object;
            return optional.isPresent() ? parse(optional.get()) : Optional.empty();
        }
        try {
            return Optional.of(UUID.fromString(object.toString()));
        } catch (IllegalArgumentException ignored) {
            return Optional.empty();
        }
    }
}