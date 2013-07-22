#version 120

varying vec3 position;
varying vec3 normal;

out vec3 modelPosition;
out vec3 modelNormal;
out vec3 viewDirection;

uniform mat4 modelMatrix;
uniform mat4 cameraMatrix;
uniform mat4 inverseMatrix;
uniform mat4 projectionMatrix;

void main() {
    modelPosition = vec3(modelMatrix * vec4(position, 1));
    modelNormal = mat3(modelMatrix) * normal;
    viewDirection = normalize(vec3(inverseMatrix * vec4(0, 0, 0, 1)) - modelPosition);

    if (dot(modelNormal, viewDirection) < 0) {
        modelNormal = -modelNormal;
    }

    gl_Position = projectionMatrix * cameraMatrix * vec4(modelPosition, 1);
}
