import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IAppUser, NewAppUser } from '../app-user.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IAppUser for edit and NewAppUserFormGroupInput for create.
 */
type AppUserFormGroupInput = IAppUser | PartialWithRequiredKeyOf<NewAppUser>;

type AppUserFormDefaults = Pick<NewAppUser, 'id'>;

type AppUserFormGroupContent = {
  id: FormControl<IAppUser['id'] | NewAppUser['id']>;
  email: FormControl<IAppUser['email']>;
  address: FormControl<IAppUser['address']>;
  phone: FormControl<IAppUser['phone']>;
  gender: FormControl<IAppUser['gender']>;
  department: FormControl<IAppUser['department']>;
  description: FormControl<IAppUser['description']>;
  latitude: FormControl<IAppUser['latitude']>;
  longitude: FormControl<IAppUser['longitude']>;
  userType: FormControl<IAppUser['userType']>;
  user: FormControl<IAppUser['user']>;
  reviews: FormControl<IAppUser['reviews']>;
  rewards: FormControl<IAppUser['rewards']>;
  govOfficialContent: FormControl<IAppUser['govOfficialContent']>;
};

export type AppUserFormGroup = FormGroup<AppUserFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class AppUserFormService {
  createAppUserFormGroup(appUser: AppUserFormGroupInput = { id: null }): AppUserFormGroup {
    const appUserRawValue = {
      ...this.getFormDefaults(),
      ...appUser,
    };
    return new FormGroup<AppUserFormGroupContent>({
      id: new FormControl(
        { value: appUserRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      email: new FormControl(appUserRawValue.email),
      address: new FormControl(appUserRawValue.address),
      phone: new FormControl(appUserRawValue.phone, {
        validators: [Validators.pattern('^[0-9]{10}$')],
      }),
      gender: new FormControl(appUserRawValue.gender),
      department: new FormControl(appUserRawValue.department),
      description: new FormControl(appUserRawValue.description),
      latitude: new FormControl(appUserRawValue.latitude),
      longitude: new FormControl(appUserRawValue.longitude),
      userType: new FormControl(appUserRawValue.userType),
      user: new FormControl(appUserRawValue.user),
      reviews: new FormControl(appUserRawValue.reviews),
      rewards: new FormControl(appUserRawValue.rewards),
      govOfficialContent: new FormControl(appUserRawValue.govOfficialContent),
    });
  }

  getAppUser(form: AppUserFormGroup): IAppUser | NewAppUser {
    return form.getRawValue() as IAppUser | NewAppUser;
  }

  resetForm(form: AppUserFormGroup, appUser: AppUserFormGroupInput): void {
    const appUserRawValue = { ...this.getFormDefaults(), ...appUser };
    form.reset(
      {
        ...appUserRawValue,
        id: { value: appUserRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): AppUserFormDefaults {
    return {
      id: null,
    };
  }
}
