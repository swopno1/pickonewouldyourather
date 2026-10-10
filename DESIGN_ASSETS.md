# Design Assets Documentation

This document describes all visual assets, design guidelines, typography, and color schemes for **Pick One! – Would You Rather**.

---

## 1. Brand Identity & Design Concept

- **Core Theme:** Energetic, vibrant party dilemma game designed with Material 3 principles and rich contrasting colors.
- **Visual Vibe:** Playful yet modern dark atmosphere (#0F172A) that makes the bright coral-orange (Option A) and luminous cyan-blue (Option B) cards pop with high contrast and readable typography.

---

## 2. Color Palette (`Color.kt`)

| Token | Hex Value | Usage |
|---|---|---|
| `DarkBackground` | `#0F172A` | Primary background color |
| `DarkSurface` | `#1E293B` | Dialogs, top app bar, action pills |
| `DarkSurfaceVariant`| `#334155` | Secondary action containers & borders |
| `PrimaryOrange` | `#FF5722` | Option A card color, Next buttons |
| `PrimaryOrangeLight`| `#FF8A65` | Option A card gradient start |
| `PrimaryOrangeDark` | `#D84315` | Option A card gradient end |
| `PrimaryCyan` | `#00B0FF` | Option B card color |
| `PrimaryCyanLight` | `#80D8FF` | Option B card gradient start |
| `PrimaryCyanDark` | `#0091EA` | Option B card gradient end |
| `AccentGold` | `#FFD54F` | Streak flame badges, language pill indicator |
| `PureWhite` | `#FFFFFF` | High-contrast card text and primary icons |
| `TextLightSecondary`| `#94A3B8` | Subtitles, helper text, and question stats |

---

## 3. Store Graphics Specification (`/play_store_assets/`)

| Asset | File Path | Resolution | Format | Destination |
|---|---|---|---|---|
| **App Icon** | `play_store_assets/app-icon/app-icon.png` | 512 × 512 px | PNG (32-bit RGBA) | Google Play Icon Listing |
| **Feature Graphic** | `play_store_assets/feature-graphic/feature-graphic.png` | 1024 × 500 px | PNG | Google Play Feature Graphic |
| **Phone Screenshot 1** | `play_store_assets/phone/phone-01.png` | 1080 × 1920 px | PNG | Google Play Phone Screenshots |
| **Phone Screenshot 2** | `play_store_assets/phone/phone-02.png` | 1080 × 1920 px | PNG | Google Play Phone Screenshots |
| **Phone Screenshot 3** | `play_store_assets/phone/phone-03.png` | 1080 × 1920 px | PNG | Google Play Phone Screenshots |
| **Phone Screenshot 4** | `play_store_assets/phone/phone-04.png` | 1080 × 1920 px | PNG | Google Play Phone Screenshots |
| **Tablet Screenshot 1** | `play_store_assets/tablet/tablet-01.png` | 1920 × 1080 px | PNG | Google Play 7-10" Tablet Screenshots |

---

## 4. In-App Launcher Icons (`res/mipmap-*/`)

Adaptive icons generated following Android Material You specifications:
- **Foreground:** `res/drawable/ic_launcher_foreground.xml` (centered on 66dp canvas)
- **Background:** `res/drawable/ic_launcher_background.xml` (solid `#1E1B4B`)
- **Adaptive Wrappers:** `res/mipmap-anydpi-v26/ic_launcher.xml` and `ic_launcher_round.xml`
- **Raster Fallbacks:** 48px (mdpi), 72px (hdpi), 96px (xhdpi), 144px (xxhdpi), 192px (xxxhdpi) for square and circular icons.

---

## 5. Proprietary Branding Notice

© 2026 ViveScript Solutions LLC. All rights reserved.  
The brand name, logos, app icons, and marketing assets are proprietary property of ViveScript Solutions LLC.
