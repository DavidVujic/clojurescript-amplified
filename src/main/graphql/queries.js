/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const getUserSettings = /* GraphQL */ `
  query GetUserSettings($id: ID!) {
    getUserSettings(id: $id) {
      id
      summary
      createdAt
      updatedAt
      owner
    }
  }
`;
export const listUserSettings = /* GraphQL */ `
  query ListUserSettings(
    $filter: ModelUserSettingsFilterInput
    $limit: Int
    $nextToken: String
  ) {
    listUserSettings(filter: $filter, limit: $limit, nextToken: $nextToken) {
      items {
        id
        summary
        createdAt
        updatedAt
        owner
      }
      nextToken
    }
  }
`;
